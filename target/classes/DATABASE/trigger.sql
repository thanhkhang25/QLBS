
-- Trigger cập nhật số lượng tồn kho của Sách
CREATE TRIGGER trg_CapNhatSoLuongTonKho
ON Sach
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
    SET NOCOUNT ON;

    UPDATE Sach
    SET soLuongTonKho = (
        COALESCE((SELECT SUM(soLuong) FROM ChiTietPhieuNhap WHERE ChiTietPhieuNhap.maSach = Sach.maSach), 0) 
        - COALESCE((SELECT SUM(soLuong) FROM ChiTietPhieuXuat WHERE ChiTietPhieuXuat.maSach = Sach.maSach), 0)
        - COALESCE((SELECT SUM(soLuong) FROM ChiTietHoaDon WHERE ChiTietHoaDon.maSach = Sach.maSach), 0)
    )
    WHERE maSach IN (
        SELECT maSach FROM inserted
        UNION
        SELECT maSach FROM deleted
    );
END;
GO

-- Trigger cập nhật khuyến mãi cho hoá đơn
CREATE TRIGGER trg_TuDongThemKhuyenMai_HoaDon
ON HoaDon
AFTER INSERT
AS
BEGIN
    SET NOCOUNT ON;

    -- Cập nhật mã khuyến mãi cho hóa đơn nếu có chương trình đang diễn ra
    UPDATE hd
    SET hd.maKM = km.maKM
    FROM HoaDon hd
    INNER JOIN inserted i ON hd.maHoaDon = i.maHoaDon
    INNER JOIN KhuyenMai km ON 
        GETDATE() BETWEEN km.ngayBatDau AND km.ngayKetThuc
        AND km.trangThai = N'Đang diễn ra'
    WHERE hd.maKM IS NULL; -- Chỉ áp dụng nếu chưa có khuyến mãi

    -- Cập nhật trạng thái khuyến mãi nếu đã hết hạn
    UPDATE KhuyenMai
    SET trangThai = N'Đã kết thúc'
    WHERE ngayKetThuc < GETDATE() AND trangThai = N'Đang diễn ra';
END;
GO

-- Trigger cập nhật khuyến mãi cho sách trong hoá đơn
CREATE TRIGGER trg_TuDongThemKhuyenMai_ChiTiet
ON ChiTietHoaDon
AFTER INSERT
AS
BEGIN
    SET NOCOUNT ON;
    -- Cập nhật mã khuyến mãi và giá sau khuyến mãi nếu có chương trình đang diễn ra
    UPDATE cthd
    SET 
        maKM = km.maKM,
        giaSauKhuyenMai = ckm.giaDaGiam
    FROM ChiTietHoaDon cthd
    INNER JOIN inserted i ON cthd.maHoaDon = i.maHoaDon AND cthd.maSach = i.maSach
    INNER JOIN ChiTietKhuyenMaiSach ckm ON cthd.maSach = ckm.maSach
    INNER JOIN KhuyenMai km ON ckm.maKM = km.maKM
    WHERE 
        GETDATE() BETWEEN km.ngayBatDau AND km.ngayKetThuc
        AND km.trangThai = N'Đang diễn ra'
        AND cthd.maKM IS NULL; -- Chỉ cập nhật nếu chưa có khuyến mãi

    -- Cập nhật trạng thái khuyến mãi nếu đã hết hạn
    UPDATE KhuyenMai
    SET trangThai = N'Đã kết thúc'
    WHERE ngayKetThuc < GETDATE() AND trangThai = N'Đang diễn ra';
END;
GO