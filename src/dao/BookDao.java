package dao;

import core.Db;
import entity.Book;
import entity.Car;
import entity.Model;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BookDao {
    private final Connection con;
    private  final CarDao carDao;

    public BookDao() {
        this.con= Db.getInstance();
        this.carDao = new CarDao();
    }

    public ArrayList<Book> findAll() {
        return this.selectByQuery("SELECT * FROM public.\"Book\" ORDER BY book_id ASC");
    }
    public  ArrayList<Book> selectByQuery(String query){
        ArrayList<Book> books = new ArrayList<>();
        try {
            ResultSet rs = this.con.createStatement().executeQuery(query);
            while (rs.next()) {
                books.add(this.match(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public Book match(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("book_id"));
        book.setbCase(rs.getString("book_case"));
        book.setCar_id(rs.getInt("book_car_id"));
        book.setName(rs.getString("book_name"));
        book.setStrt_date(LocalDate.parse(rs.getString("book_strt_date")));
        book.setFnsh_date(LocalDate.parse(rs.getString("book_fnsh_date")));
        book.setCar(this.carDao.getById(rs.getInt("book_car_id")));
        book.setIdno(rs.getString("book_idno"));
        book.setMpno(rs.getString("book_mpno"));
        book.setMail(rs.getString("book_mail"));
        book.setNote(rs.getString("book_note"));
        book.setPrc(rs.getInt("book_prc"));
        return book;

    }
    public boolean save(Book book) {
        String query = "INSERT INTO public.\"Book\" " +
                "(" +
                "book_car_id," +
                "book_name," +
                "book_idno," +
                "book_mpno," +
                "book_mail," +
                "book_strt_date," +
                "book_fnsh_date," +
                "book_prc," +
                "book_case," +
                "book_note" +
                ")" +
                " VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pr = con.prepareStatement(query);
            pr.setInt(1, book.getCar_id());
            pr.setString(2, book.getName());
            pr.setString(3, book.getIdno());
            pr.setString(4, book.getMpno());
            pr.setString(5, book.getMail());
            pr.setDate(6, Date.valueOf(book.getStrt_date()));
            pr.setDate(7, Date.valueOf(book.getFnsh_date()));
            pr.setInt(8, book.getPrc());
            pr.setString(9, book.getbCase());
            pr.setString(10, book.getNote());
            return pr.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    public Book getById(int id) {
        Book obj = null;
        String query = "SELECT * FROM public.\"Book\" WHERE book_id = ?";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = this.match(rs);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return obj;
    }
    public boolean delete(int bookId) {
        String query = "DELETE FROM public.\"Book\" WHERE book_id = ?";

        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, bookId);
            return pr.executeUpdate() != -1;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return true;
    }
}
