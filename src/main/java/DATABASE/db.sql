CREATE DATABASE QuanLyNhaSach;
GO

USE QuanLyNhaSach;
GO

CREATE TABLE NhanVien (
    maNV INT PRIMARY KEY IDENTITY(1,1),
    tenNV NVARCHAR(100) NOT NULL,
    ngaySinh DATE,
    gioiTinh NVARCHAR(3) CHECK (gioiTinh IN (N'Nam', N'Nữ')),
    sdt NVARCHAR(15),
    email NVARCHAR(100),
    diaChi NVARCHAR(255),
    ngayVaoLam DATE,
    chiNhanh NVARCHAR(100),
    trangThai NVARCHAR(20)CHECK (trangThai IN (N'Hoạt động', N'Đã nghỉ', N'Tạm ngừng')) DEFAULT N'Hoạt động'
);
GO


CREATE TABLE TaiKhoan (
    maTK INT PRIMARY KEY IDENTITY(1,1),
    maNV INT UNIQUE,
    matKhau NVARCHAR(255) NOT NULL,
    chucVu NVARCHAR(50) CHECK (chucVu IN (N'Admin', N'Quản lý kho hàng', N'Quản lý nhân viên', N'Nhân viên bán hàng')),
    trangThai NVARCHAR(20) CHECK (trangThai IN (N'Hoạt động', N'Bị khóa', N'Chờ kích hoạt')) DEFAULT N'Hoạt động',
    FOREIGN KEY (maNV) REFERENCES NhanVien(maNV)
);
GO

CREATE TABLE ChamCong (
    maCC INT PRIMARY KEY IDENTITY(1,1),
    maNV INT,
    thoiGianChamCong DATETIME DEFAULT GETDATE(),
    FOREIGN KEY (maNV) REFERENCES NhanVien(maNV)
);
GO

CREATE TABLE Luong (
    maLuong INT PRIMARY KEY IDENTITY(1,1),
    maNV INT,
    thang INT,
    nam INT,
    soNgayLam INT,
    heSoLuong FLOAT DEFAULT 2.34,
    luongCoBan FLOAT DEFAULT 1800000,
    thuong FLOAT,
    khauTru FLOAT,
    phuCapXang FLOAT,
    phuCapBHXH FLOAT,
    phuCapBHYT FLOAT,
    phuCapBHTN FLOAT,
    tongLuongNhan FLOAT,
    trangThai NVARCHAR(20) CHECK (trangThai IN (N'Đã thanh toán', N'Chưa thanh toán', N'Đang xử lý')) DEFAULT N'Chưa thanh toán',
    FOREIGN KEY (maNV) REFERENCES NhanVien(maNV)
);
GO

CREATE TABLE DonXinNghi (
    maDon INT PRIMARY KEY IDENTITY(1,1),
    maNV INT,
    maNguoiDuyet INT NULL,
    ngayNopDon DATE DEFAULT GETDATE(),
    noiDung NVARCHAR(255) CHECK (noiDung IN (N'Xin nghỉ việc', N'Nghỉ thai sản', N'Lý do khác(bệnh, gia đình)')),
    ngayBatDau DATE,
    soNgayNghi INT CHECK (soNgayNghi > 0),
    ngayKetThuc AS DATEADD(DAY, soNgayNghi, ngayBatDau) PERSISTED,
    ngayDuyet DATE NULL,
    trangThai NVARCHAR(20) CHECK (trangThai IN (N'Chờ duyệt', N'Đã duyệt', N'Bị từ chối')) DEFAULT N'Chờ duyệt',
    FOREIGN KEY (maNguoiDuyet) REFERENCES NhanVien(maNV),
    FOREIGN KEY (maNV) REFERENCES NhanVien(maNV)
);
GO

CREATE TABLE NhaCungCap (
    maNCC INT PRIMARY KEY IDENTITY(1,1),
    tenNCC NVARCHAR(100),
    email NVARCHAR(100),
    sdt NVARCHAR(15),
    diaChi NVARCHAR(255),
    trangThai NVARCHAR(20)
);
GO

CREATE TABLE Sach (
    maSach INT PRIMARY KEY IDENTITY(1,1),
    tenSach NVARCHAR(255),
    theLoai NVARCHAR(100),
    tacGia NVARCHAR(100),
    donViTinh NVARCHAR(100) CHECK (donViTinh IN (N'Cuốn', N'Bộ', N'Hộp')) DEFAULT N'Cuốn',
    giaBan FLOAT,
    giaDaGiam FLOAT,
    giaNhap FLOAT,
    soLuongTonKho INT DEFAULT 0,
    chiNhanh NVARCHAR(100),
    trangThai NVARCHAR(20) CHECK (trangThai IN (N'Còn hàng', N'Hết hàng', N'Ngừng bán')) DEFAULT N'Còn hàng'
);
GO

CREATE TABLE KhuyenMai (
    maKM INT PRIMARY KEY IDENTITY(1,1),
    ngayBatDau DATE,
    ngayKetThuc DATE,
    phanTramGiam INT CHECK (phanTramGiam BETWEEN 0 AND 100),
    trangThai NVARCHAR(20) CHECK (trangThai IN (N'Đang diễn ra', N'Đã kết thúc')) DEFAULT N'Đang diễn ra'
);
GO

CREATE TABLE PhieuNhap (
    maPN INT PRIMARY KEY IDENTITY(1,1),
    maNV INT,
    maNCC INT,
    ngayNhap DATE DEFAULT GETDATE(),
    tongTien FLOAT CHECK (tongTien >= 0),
    trangThai NVARCHAR(20) CHECK (trangThai IN (N'Chờ duyệt', N'Đã duyệt')) DEFAULT N'Đã duyệt',
    FOREIGN KEY (maNV) REFERENCES NhanVien(maNV),
    FOREIGN KEY (maNCC) REFERENCES NhaCungCap(maNCC)
);
GO

CREATE TABLE ChiTietPhieuNhap (
    maPN INT,
    maSach INT,
    soLuong INT CHECK (soLuong >= 1),
    giaNhap FLOAT CHECK (giaNhap >= 0),
    PRIMARY KEY (maPN, maSach),
    FOREIGN KEY (maPN) REFERENCES PhieuNhap(maPN),
    FOREIGN KEY (maSach) REFERENCES Sach(maSach)
);
GO

CREATE TABLE PhieuXuat (
    maPX INT PRIMARY KEY IDENTITY(1,1),
    maNV INT,
    ngayXuat DATE DEFAULT GETDATE(),
    chiNhanh NVARCHAR(100),
    trangThai NVARCHAR(20) CHECK (trangThai IN (N'Đã trả', N'Đã duyệt')) DEFAULT N'Đã duyệt',
    FOREIGN KEY (maNV) REFERENCES NhanVien(maNV)
);
GO

CREATE TABLE ChiTietPhieuXuat (
    maPX INT,
    maSach INT,
    soLuong INT,
    PRIMARY KEY (maPX, maSach),
    FOREIGN KEY (maPX) REFERENCES PhieuXuat(maPX),
    FOREIGN KEY (maSach) REFERENCES Sach(maSach)
);
GO

CREATE TABLE HoaDon (
    maHoaDon INT PRIMARY KEY IDENTITY(1,1),
    maNV INT,
    maKM INT NULL,
    ngayBan DATE,
    tongTien FLOAT CHECK (tongTien >= 0),
    chiNhanh NVARCHAR(100),
    trangThai NVARCHAR(20) CHECK (trangThai IN (N'Chưa thanh toán', N'Đã thanh toán', N'Đã hủy')) DEFAULT N'Đã thanh toán',
    FOREIGN KEY (maKM) REFERENCES KhuyenMai(maKM),
    FOREIGN KEY (maNV) REFERENCES NhanVien(maNV)
);
GO

CREATE TABLE ChiTietHoaDon (
    maHoaDon INT,
    maSach INT,
    maKM INT NULL,
    soLuong INT CHECK (soLuong > 0),
    donGia FLOAT CHECK (donGia >= 0), -- Giá gốc mỗi cuốn sách
    giaSauKhuyenMai FLOAT CHECK (giaSauKhuyenMai >= 0), -- Giá sau khi áp dụng khuyến mãi (nếu có)
    PRIMARY KEY (maHoaDon, maSach),
    FOREIGN KEY (maHoaDon) REFERENCES HoaDon(maHoaDon),
    FOREIGN KEY (maSach) REFERENCES Sach(maSach),
    FOREIGN KEY (maKM) REFERENCES KhuyenMai(maKM)
);
GO

CREATE TABLE ChiTietKhuyenMaiSach (
    maKM INT,
    maSach INT,
    giaDaGiam FLOAT,
    PRIMARY KEY (maKM, maSach),
    FOREIGN KEY (maSach) REFERENCES Sach(maSach),
    FOREIGN KEY (maKM) REFERENCES KhuyenMai(maKM)
);
GO

CREATE TABLE ChiTietKhuyenMaiHoaDon (
    maKM INT,
    maHD INT,
    giaHoaDon FLOAT,
    PRIMARY KEY (maKM, maHD),
    FOREIGN KEY (maHD) REFERENCES HoaDon(maHoaDon),
    FOREIGN KEY (maKM) REFERENCES KhuyenMai(maKM)
);
GO

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


-- STORE PROCEDURE

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
    @donViTinh NVARCHAR(100) = N'Cuốn',
    @giaBan FLOAT,
    @giaDaGiam FLOAT = 0,
    @giaNhap FLOAT,
    @soLuongTonKho INT = 0,
    @chiNhanh NVARCHAR(100),
    @trangThai NVARCHAR(20) = N'Còn hàng'
AS
BEGIN
    INSERT INTO Sach (tenSach, theLoai, tacGia, donViTinh, giaBan, giaDaGiam, giaNhap, soLuongTonKho, chiNhanh, trangThai)
    VALUES (@tenSach, @theLoai, @tacGia, @donViTinh, @giaBan, @giaDaGiam, @giaNhap, @soLuongTonKho, @chiNhanh, @trangThai);
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
    @soLuongTonKho INT,
    @chiNhanh NVARCHAR(100),
    @trangThai NVARCHAR(20)
AS
BEGIN
    UPDATE Sach
    SET tenSach = @tenSach, theLoai = @theLoai, tacGia = @tacGia,
        giaBan = @giaBan, giaDaGiam = @giaDaGiam, giaNhap = @giaNhap,
        soLuongTonKho = @soLuongTonKho, chiNhanh = @chiNhanh, trangThai = @trangThai
    WHERE maSach = @maSach;
END;
GO

-- Xóa sách
CREATE PROCEDURE sp_XoaSach
    @maSach INT
AS
BEGIN
    DELETE FROM Sach WHERE maSach = @maSach;
END;
GO

-- Thêm nhà cung cấp mới
CREATE PROCEDURE sp_ThemNhaCungCap
    @tenNCC NVARCHAR(255),
    @diaChi NVARCHAR(255),
    @soDienThoai NVARCHAR(20)
AS
BEGIN
    INSERT INTO NhaCungCap (tenNCC, diaChi, sdt)
    VALUES (@tenNCC, @diaChi, @soDienThoai);
END;
GO

-- Cập nhật thông tin nhà cung cấp
CREATE PROCEDURE sp_CapNhatNhaCungCap
    @maNCC INT,
    @tenNCC NVARCHAR(255),
    @diaChi NVARCHAR(255),
    @soDienThoai NVARCHAR(20)
AS
BEGIN
    UPDATE NhaCungCap
    SET tenNCC = @tenNCC, diaChi = @diaChi, sdt = @soDienThoai
    WHERE maNCC = @maNCC;
END;
GO

-- Xóa nhà cung cấp
CREATE PROCEDURE sp_XoaNhaCungCap
    @maNCC INT
AS
BEGIN
    DELETE FROM NhaCungCap WHERE maNCC = @maNCC;
END;
GO

-- Lấy danh sách nhà cung cấp
CREATE PROCEDURE sp_LayNhaCungCap
AS
BEGIN
    SELECT * FROM NhaCungCap;
END;
GO

-- Thêm phiếu nhập mới
CREATE PROCEDURE sp_ThemPhieuNhap
    @maNV INT,
    @maNCC INT,
    @tongTien FLOAT,
    @trangThai NVARCHAR(20) = N'Đã duyệt'
AS
BEGIN
    INSERT INTO PhieuNhap (maNV, maNCC, ngayNhap, tongTien, trangThai)
    VALUES (@maNV, @maNCC, GETDATE(), @tongTien, @trangThai);
END;
GO

-- Cập nhật phiếu nhập
CREATE PROCEDURE sp_CapNhatPhieuNhap
    @maPN INT,
    @trangThai NVARCHAR(20)
AS
BEGIN
    UPDATE PhieuNhap
    SET trangThai = @trangThai
    WHERE maPN = @maPN;
END;
GO

-- Lấy danh sách phiếu nhập
CREATE PROCEDURE sp_LayPhieuNhap
AS
BEGIN
    SELECT * FROM PhieuNhap;
END;
GO

-- Thêm phiếu xuất mới
CREATE PROCEDURE sp_ThemPhieuXuat
    @maNV INT,
    @chiNhanh NVARCHAR(100),
    @trangThai NVARCHAR(20) = N'Đã duyệt'
AS
BEGIN
    INSERT INTO PhieuXuat (maNV, ngayXuat, chiNhanh, trangThai)
    VALUES (@maNV, GETDATE(), @chiNhanh, @trangThai);
END;
GO

-- Cập nhật phiếu xuất
CREATE PROCEDURE sp_CapNhatPhieuXuat
    @maPX INT,
    @trangThai NVARCHAR(20)
AS
BEGIN
    UPDATE PhieuXuat
    SET trangThai = @trangThai
    WHERE maPX = @maPX;
END;
GO

-- Lấy danh sách phiếu xuất
CREATE PROCEDURE sp_LayPhieuXuat
AS
BEGIN
    SELECT * FROM PhieuXuat;
END;
GO

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

-- Thêm chi tiết phiếu nhập mới
CREATE PROCEDURE sp_ThemChiTietPhieuNhap
    @maPN INT,
    @maSach INT,
    @soLuong INT,
    @giaNhap FLOAT
AS
BEGIN
    INSERT INTO ChiTietPhieuNhap (maPN, maSach, soLuong, giaNhap)
    VALUES (@maPN, @maSach, @soLuong, @giaNhap);

    -- Cập nhật số lượng tồn kho trong bảng Sách
    UPDATE Sach
    SET soLuongTonKho = soLuongTonKho + @soLuong
    WHERE maSach = @maSach;
END;
GO

-- Cập nhật chi tiết phiếu nhập
CREATE PROCEDURE sp_CapNhatChiTietPhieuNhap
    @maPN INT,
    @maSach INT,
    @soLuong INT,
    @giaNhap FLOAT
AS
BEGIN
    UPDATE ChiTietPhieuNhap
    SET soLuong = @soLuong, giaNhap = @giaNhap
    WHERE maPN = @maPN AND maSach = @maSach;
END;
GO

-- Xóa chi tiết phiếu nhập
CREATE PROCEDURE sp_XoaChiTietPhieuNhap
    @maPN INT,
    @maSach INT
AS
BEGIN
    DELETE FROM ChiTietPhieuNhap
    WHERE maPN = @maPN AND maSach = @maSach;
END;
GO

-- Lấy danh sách chi tiết phiếu nhập theo mã phiếu nhập
CREATE PROCEDURE sp_LayChiTietPhieuNhap
    @maPN INT
AS
BEGIN
    SELECT * FROM ChiTietPhieuNhap WHERE maPN = @maPN;
END;
GO

-- Thêm chi tiết phiếu xuất mới
CREATE PROCEDURE sp_ThemChiTietPhieuXuat
    @maPX INT,
    @maSach INT,
    @soLuong INT
AS
BEGIN
    -- Kiểm tra tồn kho trước khi xuất hàng
    IF (SELECT soLuongTonKho FROM Sach WHERE maSach = @maSach) >= @soLuong
    BEGIN
        INSERT INTO ChiTietPhieuXuat (maPX, maSach, soLuong)
        VALUES (@maPX, @maSach, @soLuong);

        -- Cập nhật số lượng tồn kho
        UPDATE Sach
        SET soLuongTonKho = soLuongTonKho - @soLuong
        WHERE maSach = @maSach;
    END
    ELSE
    BEGIN
        RAISERROR (N'Không đủ hàng trong kho!', 16, 1);
    END
END;
GO

-- Cập nhật chi tiết phiếu xuất
CREATE PROCEDURE sp_CapNhatChiTietPhieuXuat
    @maPX INT,
    @maSach INT,
    @soLuong INT
AS
BEGIN
    UPDATE ChiTietPhieuXuat
    SET soLuong = @soLuong
    WHERE maPX = @maPX AND maSach = @maSach;
END;
GO

-- Xóa chi tiết phiếu xuất
CREATE PROCEDURE sp_XoaChiTietPhieuXuat
    @maPX INT,
    @maSach INT
AS
BEGIN
    DELETE FROM ChiTietPhieuXuat
    WHERE maPX = @maPX AND maSach = @maSach;
END;
GO

-- Lấy danh sách chi tiết phiếu xuất theo mã phiếu xuất
CREATE PROCEDURE sp_LayChiTietPhieuXuat
    @maPX INT
AS
BEGIN
    SELECT * FROM ChiTietPhieuXuat WHERE maPX = @maPX;
END;
GO

-- Thêm chi tiết hóa đơn mới
CREATE PROCEDURE sp_ThemChiTietHoaDon
    @maHoaDon INT,
    @maSach INT,
    @soLuong INT,
    @donGia FLOAT
AS
BEGIN
    -- Kiểm tra tồn kho trước khi bán
    IF (SELECT soLuongTonKho FROM Sach WHERE maSach = @maSach) >= @soLuong
    BEGIN
        INSERT INTO ChiTietHoaDon (maHoaDon, maSach, soLuong, donGia)
        VALUES (@maHoaDon, @maSach, @soLuong, @donGia);

        -- Cập nhật số lượng tồn kho sau khi bán
        UPDATE Sach
        SET soLuongTonKho = soLuongTonKho - @soLuong
        WHERE maSach = @maSach;
    END
    ELSE
    BEGIN
        RAISERROR (N'Không đủ hàng trong kho để bán!', 16, 1);
    END
END;
GO

-- Cập nhật chi tiết hóa đơn
CREATE PROCEDURE sp_CapNhatChiTietHoaDon
    @maHoaDon INT,
    @maSach INT,
    @soLuong INT,
    @donGia FLOAT
AS
BEGIN
    UPDATE ChiTietHoaDon
    SET soLuong = @soLuong, donGia = @donGia
    WHERE maHoaDon = @maHoaDon AND maSach = @maSach;
END;
GO

-- Xóa chi tiết hóa đơn
CREATE PROCEDURE sp_XoaChiTietHoaDon
    @maHoaDon INT,
    @maSach INT
AS
BEGIN
    DELETE FROM ChiTietHoaDon
    WHERE maHoaDon = @maHoaDon AND maSach = @maSach;
END;
GO

-- Lấy danh sách chi tiết hóa đơn theo mã hóa đơn
CREATE PROCEDURE sp_LayChiTietHoaDon
    @maHoaDon INT
AS
BEGIN
    SELECT * FROM ChiTietHoaDon WHERE maHoaDon = @maHoaDon;
END;
GO




-- Duy thêm

-- Lấy danh sách Luong
CREATE PROCEDURE sp_LayDanhSachLuong
AS
BEGIN
    SELECT * FROM Luong;
END;
GO

-- Thêm Luong mới
CREATE PROCEDURE sp_ThemLuong
    @maNV INT,
    @thang INT,
    @nam INT,
    @soNgayLam INT,
    @luongCoBan FLOAT,
    @thuong FLOAT,
    @khauTru FLOAT,
    @phuCapXang FLOAT,
    @phuCapBHYT FLOAT,
    @phuCapBHXH FLOAT,
    @phuCapBHTN FLOAT,
    @tongLuongNhan FLOAT
AS
BEGIN
    INSERT INTO Luong (maNV, thang, nam, soNgayLam, luongCoBan, thuong, khauTru, phuCapXang, phuCapBHYT, phuCapBHXH, phuCapBHTN, tongLuongNhan)
    VALUES (@maNV, @thang, @nam, @soNgayLam, @luongCoBan, @thuong, @khauTru, @phuCapXang, @phuCapBHYT, @phuCapBHXH, @phuCapBHTN, @tongLuongNhan);
END;
GO

-- Cập nhật Luong
CREATE PROCEDURE sp_CapNhatLuong
    @maLuong INT,
    @maNV INT,
    @thang INT,
    @nam INT,
    @soNgayLam INT,
    @luongCoBan FLOAT,
    @thuong FLOAT,
    @khauTru FLOAT,
    @phuCapXang FLOAT,
    @phuCapBHYT FLOAT,
    @phuCapBHXH FLOAT,
    @phuCapBHTN FLOAT,
    @tongLuongNhan FLOAT
AS
BEGIN
    UPDATE Luong
    SET maNV = @maNV, thang = @thang, nam = @nam, soNgayLam = @soNgayLam,
        luongCoBan = @luongCoBan, thuong = @thuong, khauTru = @khauTru,
        phuCapXang = @phuCapXang, phuCapBHYT = @phuCapBHYT, phuCapBHXH = @phuCapBHXH,
        phuCapBHTN = @phuCapBHTN, tongLuongNhan = @tongLuongNhan
    WHERE maLuong = @maLuong;
END;
GO

-- Xóa Luong
CREATE PROCEDURE sp_XoaLuong
    @maLuong INT
AS
BEGIN
    DELETE FROM Luong WHERE maLuong = @maLuong;
END;
GO

-- Lấy danh sách NhanVien
CREATE PROCEDURE sp_LayDanhSachNhanVien
AS
BEGIN
    SELECT * FROM NhanVien;
END;
GO

-- Thêm NhanVien mới
CREATE PROCEDURE sp_ThemNhanVien
    @tenNV NVARCHAR(100),
    @ngaySinh DATE,
    @gioiTinh NVARCHAR(3),
    @sdt NVARCHAR(15),
    @email NVARCHAR(100),
    @diaChi NVARCHAR(255),
    @ngayVaoLam DATE,
    @chiNhanh NVARCHAR(100),
    @trangThai NVARCHAR(20) = N'Hoạt động'
AS
BEGIN
    INSERT INTO NhanVien (tenNV, ngaySinh, gioiTinh, sdt, email, diaChi, ngayVaoLam, chiNhanh, trangThai)
    VALUES (@tenNV, @ngaySinh, @gioiTinh, @sdt, @email, @diaChi, @ngayVaoLam, @chiNhanh, @trangThai);
END;
GO
drop procedure dbo.sp_ThemNhanVien;
EXEC sp_helptext 'sp_ThemNhanVien';


-- Cập nhật NhanVien
CREATE PROCEDURE sp_CapNhatNhanVien
    @maNV INT,
    @tenNV NVARCHAR(100),
    @ngaySinh DATE,
    @gioiTinh NVARCHAR(3),
    @sdt NVARCHAR(15),
    @email NVARCHAR(100),
    @diaChi NVARCHAR(255),
    @ngayVaoLam DATE,
    @chiNhanh NVARCHAR(100)
AS
BEGIN
    UPDATE NhanVien
    SET tenNV = @tenNV, ngaySinh = @ngaySinh, gioiTinh = @gioiTinh,
        sdt = @sdt, email = @email, diaChi = @diaChi,
        ngayVaoLam = @ngayVaoLam, chiNhanh = @chiNhanh
    WHERE maNV = @maNV;
END;
GO

-- Xóa NhanVien
CREATE PROCEDURE sp_XoaNhanVien
    @maNV INT
AS
BEGIN
    DELETE FROM NhanVien WHERE maNV = @maNV;
END;
GO


-- Lấy danh sách TaiKhoan
CREATE PROCEDURE sp_LayTaiKhoan
AS
BEGIN
    SELECT * FROM TaiKhoan;
END;
GO

-- Thêm TaiKhoan mới
CREATE PROCEDURE sp_ThemTaiKhoan
    @maNV INT,
    @matKhau NVARCHAR(255),
    @chucVu NVARCHAR(50),
    @trangThai NVARCHAR(20)
AS
BEGIN
    INSERT INTO TaiKhoan (maNV, matKhau, chucVu, trangThai)
    VALUES (@maNV, @matKhau, @chucVu, @trangThai);
END;
GO

-- Cập nhật TaiKhoan
CREATE PROCEDURE sp_CapNhatTaiKhoan
    @maTK INT,
    @maNV INT,
    @matKhau NVARCHAR(255),
    @chucVu NVARCHAR(50),
    @trangThai NVARCHAR(20)
AS
BEGIN
    UPDATE TaiKhoan
    SET maNV = @maNV, matKhau = @matKhau, chucVu = @chucVu, trangThai = @trangThai
    WHERE maTK = @maTK;
END;
GO

-- Xóa TaiKhoan
CREATE PROCEDURE sp_XoaTaiKhoan
    @maTK INT
AS
BEGIN
    DELETE FROM TaiKhoan WHERE maTK = @maTK;
END;
GO


-- Lấy danh sách ChamCong
CREATE PROCEDURE sp_LayDanhSachChamCong
AS
BEGIN
    SELECT * FROM ChamCong;
END;
GO

-- Thêm mới ChamCong
CREATE PROCEDURE sp_ThemChamCong
    @maNV INT,
    @thoiGianChamCong DATETIME
AS
BEGIN
    INSERT INTO ChamCong (maNV, thoiGianChamCong)
    VALUES (@maNV, @thoiGianChamCong);
END;
GO

-- Cập nhật ChamCong
CREATE PROCEDURE sp_CapNhatChamCong
    @maCC INT,
    @maNV INT,
    @thoiGianChamCong DATETIME
AS
BEGIN
    UPDATE ChamCong
    SET maNV = @maNV,
        thoiGianChamCong = @thoiGianChamCong
    WHERE maCC = @maCC;
END;
GO

-- Xóa ChamCong
CREATE PROCEDURE sp_XoaChamCong
    @maCC INT
AS
BEGIN
    DELETE FROM ChamCong WHERE maCC = @maCC;
END;
GO


-- Lấy danh sách DonXinNghi
CREATE PROCEDURE sp_LayDonXinNghi
AS
BEGIN
    SELECT * FROM DonXinNghi;
END;
GO

-- Thêm DonXinNghi mới
CREATE PROCEDURE sp_ThemDonXinNghi
    @maNV INT,
    @maNguoiDuyet INT = NULL,
    @ngayNopDon DATETIME,
    @noiDung NVARCHAR(255),
    @ngayBatDau DATE,
    @soNgayNghi INT,
    @ngayDuyet DATETIME = NULL,
    @trangThai NVARCHAR(20)
AS
BEGIN
    INSERT INTO DonXinNghi (maNV, maNguoiDuyet, ngayNopDon, noiDung, ngayBatDau, soNgayNghi, ngayDuyet, trangThai)
    VALUES (@maNV, @maNguoiDuyet, @ngayNopDon, @noiDung, @ngayBatDau, @soNgayNghi, @ngayDuyet, @trangThai);
END;
GO

-- Cập nhật DonXinNghi
CREATE PROCEDURE sp_CapNhatDonXinNghi
    @maDon INT,
    @maNV INT,
    @maNguoiDuyet INT = NULL,
    @ngayNopDon DATETIME,
    @noiDung NVARCHAR(255),
    @ngayBatDau DATE,
    @soNgayNghi INT,
    @ngayDuyet DATETIME = NULL,
    @trangThai NVARCHAR(20)
AS
BEGIN
    UPDATE DonXinNghi
    SET maNV = @maNV,
        maNguoiDuyet = @maNguoiDuyet,
        ngayNopDon = @ngayNopDon,
        noiDung = @noiDung,
        ngayBatDau = @ngayBatDau,
        soNgayNghi = @soNgayNghi,
        ngayDuyet = @ngayDuyet,
        trangThai = @trangThai
    WHERE maDon = @maDon;
END;
GO

-- Xóa DonXinNghi
CREATE PROCEDURE sp_XoaDonXinNghi
    @maDon INT
AS
BEGIN
    DELETE FROM DonXinNghi WHERE maDon = @maDon;
END;
GO

-- Mục đích: Lấy toàn bộ danh sách tài khoản từ bảng TaiKhoan.
CREATE PROCEDURE sp_LayTaiKhoan
AS
BEGIN
    SET NOCOUNT ON;
    SELECT maTK, maNV, matKhau, chucVu, trangThai
    FROM TaiKhoan;
END;
GO

-- Mục đích: Thêm một tài khoản mới vào bảng TaiKhoan.
CREATE PROCEDURE sp_ThemTaiKhoan
    @maNV INT,
    @matKhau NVARCHAR(255),
    @chucVu NVARCHAR(50),
    @trangThai NVARCHAR(20) = N'Hoạt động'
AS
BEGIN
    SET NOCOUNT ON;
    INSERT INTO TaiKhoan (maNV, matKhau, chucVu, trangThai)
    VALUES (@maNV, @matKhau, @chucVu, @trangThai);
END;
GO

-- Mục đích: Cập nhật thông tin của một tài khoản dựa trên maTK.
CREATE PROCEDURE sp_CapNhatTaiKhoan
    @maTK INT,
    @maNV INT,
    @matKhau NVARCHAR(255),
    @chucVu NVARCHAR(50),
    @trangThai NVARCHAR(20)
AS
BEGIN
    SET NOCOUNT ON;
    UPDATE TaiKhoan
    SET 
        maNV = @maNV,
        matKhau = @matKhau,
        chucVu = @chucVu,
        trangThai = @trangThai
    WHERE maTK = @maTK;
END;
GO

-- Mục đích: Xóa tài khoản dựa trên maTK.
CREATE PROCEDURE sp_XoaTaiKhoan
    @maTK INT
AS
BEGIN
    SET NOCOUNT ON;
    DELETE FROM TaiKhoan
    WHERE maTK = @maTK;
END;
GO

-- =====================================================
-- SP: sp_GetTaiKhoanByMaNV
-- Mục đích: Lấy thông tin tài khoản dựa trên mã nhân viên.
-- Tham số:
--   @maNV INT: Mã nhân viên cần lấy tài khoản.
-- =====================================================
CREATE PROCEDURE sp_GetTaiKhoanByMaNV
    @maNV INT
AS
BEGIN
    SET NOCOUNT ON;
    SELECT maTK, maNV, matKhau, chucVu, trangThai
    FROM TaiKhoan
    WHERE maNV = @maNV;
END;
GO

-- Stored Procedure: sp_CheckChamCongToday
-- Đếm số bản ghi chấm công của một nhân viên trong ngày hôm nay
CREATE PROCEDURE sp_CheckChamCongToday
    @maNV INT
AS
BEGIN
    SET NOCOUNT ON;
    SELECT COUNT(*) 
    FROM ChamCong 
    WHERE maNV = @maNV 
      AND CAST(thoiGianChamCong AS DATE) = CAST(GETDATE() AS DATE);
END;
GO
