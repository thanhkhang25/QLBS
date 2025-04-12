-- Lấy danh sách tất cả sách
CREATE PROCEDURE sp_LayDanhSachSach
AS
BEGIN
    SELECT * FROM Sach;
END;
GO

-- Thêm sách mới
CREATE PROCEDURE sp_ThemSach
    @tenSach NVARCHAR(255),
    @theLoai NVARCHAR(100),
    @tacGia NVARCHAR(100),
    @giaBan FLOAT,
    @giaDaGiam FLOAT = 0,
    @giaNhap FLOAT,
    @chiNhanh NVARCHAR(100)
AS
BEGIN
    INSERT INTO Sach (tenSach, theLoai, tacGia, giaBan, giaDaGiam, giaNhap, chiNhanh)
    VALUES (@tenSach, @theLoai, @tacGia, @giaBan, @giaDaGiam, @giaNhap, @chiNhanh);
END;
GO

-- Cập nhật thông tin sách
CREATE PROCEDURE sp_CapNhatSach
    @maSach INT,
    @tenSach NVARCHAR(255),
    @theLoai NVARCHAR(100),
    @tacGia NVARCHAR(100),
    @giaBan FLOAT,
    @giaDaGiam FLOAT,
    @giaNhap FLOAT,
    @chiNhanh NVARCHAR(100),
    @trangThai NVARCHAR(20)
AS
BEGIN
    UPDATE Sach
    SET tenSach = @tenSach, theLoai = @theLoai, tacGia = @tacGia,
        giaBan = @giaBan, giaDaGiam = @giaDaGiam, giaNhap = @giaNhap,
        chiNhanh = @chiNhanh, trangThai = @trangThai
    WHERE maSach = @maSach;
END;
GO

-- Thêm nhà cung cấp mới
CREATE PROCEDURE sp_ThemNhaCungCap
    @tenNCC NVARCHAR(255),
    @email NVARCHAR(255),
    @soDienThoai NVARCHAR(20),
    @diaChi NVARCHAR(255)
AS
BEGIN
    INSERT INTO NhaCungCap (tenNCC, diaChi, sdt, email)
    VALUES (@tenNCC, @diaChi, @soDienThoai, @email);
END;
GO

-- Cập nhật thông tin nhà cung cấp
CREATE PROCEDURE sp_CapNhatNhaCungCap
    @maNCC INT,
    @tenNCC NVARCHAR(255),
    @email NVARCHAR(255),
    @soDienThoai NVARCHAR(15),
    @diaChi NVARCHAR(255),
    @trangThai NVARCHAR(20)
AS
BEGIN
    UPDATE NhaCungCap
    SET tenNCC = @tenNCC, email = @email, diaChi = @diaChi, sdt = @soDienThoai, trangThai = @trangThai
    WHERE maNCC = @maNCC;
END;
GO

-- Lấy danh sách nhà cung cấp
CREATE PROCEDURE sp_LayDanhSachNhaCungCap
AS
BEGIN
    SELECT * FROM NhaCungCap;
END;
GO

-- Thêm phiếu nhập mới
CREATE PROCEDURE sp_ThemPhieuNhap
    @maNV INT,
    @maNCC INT,
    @tongTien FLOAT
AS
BEGIN
    INSERT INTO PhieuNhap (maNV, maNCC, ngayNhap, tongTien)
    VALUES (@maNV, @maNCC, GETDATE(), @tongTien);
END;
GO

-- Thêm chi tiết phiếu nhập
CREATE PROCEDURE sp_ThemChiTietPhieuNhap
    @maPN INT,
    @maSach INT,
    @soLuong INT,
    @giaNhap FLOAT
AS
BEGIN
    INSERT INTO ChiTietPhieuNhap (maPN, maSach, soLuong, giaNhap)
    VALUES (@maPN, @maSach, @soLuong, @giaNhap);
    
    UPDATE Sach
    SET soLuongTonKho = soLuongTonKho + @soLuong
    WHERE maSach = @maSach;
END;
GO

-- Cập nhật phiếu nhập
CREATE PROCEDURE sp_CapNhatPhieuNhap
    @maPN INT
AS
BEGIN
    UPDATE PhieuNhap
    SET trangThai = N'Đã huỷ'
    WHERE maPN = @maPN;
END;
GO

-- Lấy danh sách phiếu nhập
CREATE PROCEDURE sp_LayDanhSachPhieuNhap
AS
BEGIN
    SELECT * FROM PhieuNhap where trangThai = N'Đã duyệt';
END;
GO

-- Lấy danh sách phiếu nhập đã huỷ
CREATE PROCEDURE sp_LayDanhSachPhieuNhapDaHuy
AS
BEGIN
    SELECT * FROM PhieuNhap where trangThai = N'Đã huỷ';
END;
GO

-- Lấy danh sách chi tiết phiếu nhập
CREATE PROCEDURE sp_LayDanhSachChiTietPhieuNhap
AS
BEGIN
    SELECT * FROM ChiTietPhieuNhap;
END;
GO

-- Lấy id phiếu nhập lớn nhất
CREATE PROCEDURE sp_LayIdMaxPhieuNhap
AS
BEGIN
    SELECT ISNULL(MAX(maPN), 0) AS MaxPhieuNhap FROM PhieuNhap;
END;

-- Thêm phiếu xuất mới
CREATE PROCEDURE sp_ThemPhieuXuat
    @maNV INT,
    @chiNhanh NVARCHAR(100)
AS
BEGIN
    INSERT INTO PhieuXuat (maNV, ngayXuat, chiNhanh)
    VALUES (@maNV, GETDATE(), @chiNhanh);
END;
GO

-- Lấy id phiếu xuất lớn nhất
CREATE PROCEDURE sp_LayIdMaxPhieuXuat
AS
BEGIN
    SELECT ISNULL(MAX(maPX), 0) AS MaxPhieuXuat FROM PhieuXuat;
END;
GO

-- Cập nhật phiếu xuất
CREATE PROCEDURE sp_CapNhatPhieuXuat
    @maPX INT
AS
BEGIN
    UPDATE PhieuXuat
    SET trangThai = N'Đã huỷ'
    WHERE maPX = @maPX;
END;
GO

-- Lấy danh sách phiếu xuất
CREATE PROCEDURE sp_LayDanhSachPhieuXuat
AS
BEGIN
    SELECT * FROM PhieuXuat where trangThai = N'Đã duyệt';
END;
GO

-- Lấy danh sách phiếu xuất đã huỷ
CREATE PROCEDURE sp_LayDanhSachPhieuXuatDaHuy
AS
BEGIN
    SELECT * FROM PhieuXuat where trangThai = N'Đã huỷ';
END;
GO

-- Lấy danh sách chi tiết phiếu xuất
CREATE PROCEDURE sp_LayDanhSachChiTietPhieuXuat
AS
BEGIN
    SELECT * FROM ChiTietPhieuXuat;
END;
GO

-- Thêm chi tiết phiếu xuất
CREATE PROCEDURE sp_ThemChiTietPhieuXuat
    @maPX INT,
    @maSach INT,
    @soLuong INT
AS
BEGIN
    INSERT INTO ChiTietPhieuXuat (maPX, maSach, soLuong)
    VALUES (@maPX, @maSach, @soLuong);
    
    UPDATE Sach
    SET soLuongTonKho = soLuongTonKho - @soLuong
    WHERE maSach = @maSach;
END;

-- Thêm hóa đơn mới
CREATE PROCEDURE sp_ThemHoaDon
    @maNV INT,
    @maKM INT = NULL,
    @tongTien FLOAT,
    @chiNhanh NVARCHAR(100),
    @trangThai NVARCHAR(20) = N'Đã thanh toán'
AS
BEGIN
    INSERT INTO HoaDon (maNV, maKM, ngayBan, tongTien, chiNhanh, trangThai)
    VALUES (@maNV, @maKM, GETDATE(), @tongTien, @chiNhanh, @trangThai);
END;
GO

-- Cập nhật trạng thái hóa đơn
CREATE PROCEDURE sp_CapNhatHoaDon
    @maHoaDon INT,
    @trangThai NVARCHAR(20)
AS
BEGIN
    UPDATE HoaDon
    SET trangThai = @trangThai
    WHERE maHoaDon = @maHoaDon;
END;
GO

-- Lấy danh sách hóa đơn
CREATE PROCEDURE sp_LayHoaDon
AS
BEGIN
    SELECT * FROM HoaDon;
END;
GO

-- Procedure lấy danh sách khuyến mãi cho sách
CREATE PROCEDURE sp_LayDanhSachKhuyenMaiChoSach
    @maSach INT
AS
BEGIN
    SELECT km.maKM, km.ngayBatDau, km.ngayKetThuc, km.phanTramGiam, km.trangThai, ctkms.giaDaGiam
    FROM KhuyenMai km
    JOIN ChiTietKhuyenMaiSach ctkms ON km.maKM = ctkms.maKM
    WHERE ctkms.maSach = @maSach;
END;
GO

-- Procedure lấy danh sách khuyến mãi cho hoá đơn
CREATE PROCEDURE sp_LayDanhSachKhuyenMaiChoHoaDon
AS
BEGIN
    SELECT km.maKM, km.ngayBatDau, km.ngayKetThuc, km.phanTramGiam, km.trangThai, ctkmhd.giaHoaDon
    FROM KhuyenMai km
    JOIN ChiTietKhuyenMaiHoaDon ctkmhd ON km.maKM = ctkmhd.maKM
END;
GO

CREATE PROCEDURE sp_ThemKhuyenMaiHoaDon
    @ngayBatDau DATE,
    @ngayKetThuc DATE,
    @giaHoaDon FLOAT,
    @phanTramGiam INT
AS
BEGIN
    DECLARE @trangThai NVARCHAR(20);

    -- Xét trạng thái khuyến mãi
    IF @ngayBatDau > GETDATE()
        SET @trangThai = N'Đã kết thúc';
    ELSE IF GETDATE() BETWEEN @ngayBatDau AND @ngayKetThuc
        SET @trangThai = N'Đang diễn ra';
    ELSE
        SET @trangThai = N'Đã kết thúc'; -- Ngày hiện tại đã qua thời gian khuyến mãi

    -- Thêm khuyến mãi vào bảng KhuyenMai
    INSERT INTO KhuyenMai (ngayBatDau, ngayKetThuc, phanTramGiam, trangThai)
    VALUES (@ngayBatDau, @ngayKetThuc, @phanTramGiam, @trangThai);

    -- Lấy mã khuyến mãi vừa tạo
    DECLARE @maKM INT = SCOPE_IDENTITY();
END;
GO

-- Procedure thêm khuyến mãi cho sách
CREATE PROCEDURE sp_ThemKhuyenMaiSach
    @maKM INT,
    @maSach INT,
    @giaDaGiam FLOAT
AS
BEGIN
    INSERT INTO ChiTietKhuyenMaiSach(maKM, maSach, giaDaGiam)
    VALUES (@maKM, @maSach, @giaDaGiam);
END;
GO
