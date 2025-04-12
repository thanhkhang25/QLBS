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
    trangThai NVARCHAR(20) CHECK (trangThai IN(N'Hợp tác', N'Ngừng hợp tác')) DEFAULT N'Hợp tác'
);
GO

CREATE TABLE Sach (
    maSach INT PRIMARY KEY IDENTITY(1,1),
    tenSach NVARCHAR(255),
    theLoai NVARCHAR(100),
    tacGia NVARCHAR(100),
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
    ngayNhap DATETIME DEFAULT GETDATE(),
    tongTien FLOAT CHECK (tongTien >= 0),
    trangThai NVARCHAR(20) CHECK (trangThai IN (N'Đã huỷ', N'Đã duyệt')) DEFAULT N'Đã duyệt',
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
    ngayXuat DATETIME DEFAULT GETDATE(),
    chiNhanh NVARCHAR(100),
    trangThai NVARCHAR(20) CHECK (trangThai IN (N'Đã huỷ', N'Đã duyệt')) DEFAULT N'Đã duyệt',
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
    ngayBan DATETIME,
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


-- SELECT SCHEMA_NAME(schema_id) AS SchemaName, name 
-- FROM sys.procedures;
