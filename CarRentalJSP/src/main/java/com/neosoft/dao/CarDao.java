package com.neosoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neosoft.beans.CarBean;
import com.neosoft.beans.RentedCarBeans;

public class CarDao {
	
	public static int add(CarBean bean) {
		int status = 0;
		try {
			Connection con = DB.getCon();
			String insertQuery = "INSERT INTO CAR2(CARNO,CARNAME,CARMF,CARYEAR,CARPRICE) VALUES(?,?,?,?,?);";
			PreparedStatement pst = con.prepareStatement(insertQuery);
			pst.setString(1, bean.getNumber());
			pst.setString(2, bean.getName());
			pst.setString(3, bean.getMf());
			pst.setInt(4, bean.getYear());
			pst.setInt(5, bean.getPrice());
			status = pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static List<CarBean> getAll() {
		List<CarBean> beans = new ArrayList<CarBean>();
		try {
			Connection con = DB.getCon();
			String selectQuery = "SELECT * FROM CAR2;";
			PreparedStatement pst = con.prepareStatement(selectQuery);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				CarBean bean = new CarBean();
				bean.setNumber(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setMf(rs.getString(3));
				bean.setYear(rs.getInt(4));
				bean.setPrice(rs.getInt(5));;
				bean.setStatus(rs.getString(6));
				beans.add(bean);
			}
			rs.close();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beans;
	}
	
	public static int delete(String carno) {
		int status = 0;
		try {
			Connection con = DB.getCon();
			String deleteQuery = "DELETE FROM CAR2 WHERE CARNO = ?";
			PreparedStatement pst = con.prepareStatement(deleteQuery);
			pst.setString(1, carno);
			status = pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static CarBean getByCarNo(String carno) {
		CarBean bean = new CarBean();
		try {
			Connection con = DB.getCon();
			String selectQuery = "SELECT * FROM CAR2 WHERE CARNO = ?";
			PreparedStatement pst = con.prepareStatement(selectQuery);
			pst.setString(1, carno);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				bean.setNumber(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setMf(rs.getString(3));
				bean.setYear(rs.getInt(4));
				bean.setPrice(rs.getInt(5));;
				bean.setStatus(rs.getString(6));
			}
			rs.close();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	public static int update(CarBean bean) {
		int status = 0;
		try {
			Connection con = DB.getCon();
			String updateQuery = "UPDATE CAR2 SET CARNAME = ?,CARMF = ?, CARYEAR = ?, CARPRICE = ?, CARSTATUS = ? WHERE CARNO = ?";
			PreparedStatement pst = con.prepareStatement(updateQuery);
			pst.setString(1, bean.getName());
			pst.setString(2, bean.getMf());
			pst.setInt(3, bean.getYear());
			pst.setInt(4, bean.getPrice());
			pst.setString(5, bean.getStatus());
			pst.setString(6, bean.getNumber());
			status = pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static List<CarBean> getAvailableCar(){
		List<CarBean> beans = new ArrayList<CarBean>();
		try {
			Connection con = DB.getCon();
			String selectQuery = "SELECT * FROM CAR2 WHERE CARSTATUS = 'YES'";
			PreparedStatement pst = con.prepareStatement(selectQuery);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				CarBean bean = new CarBean();
				bean.setNumber(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setMf(rs.getString(3));
				bean.setYear(rs.getInt(4));
				bean.setPrice(rs.getInt(5));
				bean.setStatus(rs.getString(6));
				beans.add(bean);
			}
			rs.close();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beans;
	}
	
	public static List<RentedCarBeans> getRentedCar(int id){
		List<RentedCarBeans> beans = new ArrayList<RentedCarBeans>();
		try {
			Connection con = DB.getCon();
			String selectQuery = "SELECT * FROM RENTCAR2 WHERE RETURNSTAT = 'NO' AND CUSTID = ?";
			PreparedStatement pst = con.prepareStatement(selectQuery);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				RentedCarBeans bean = new RentedCarBeans();
				bean.setCarno(rs.getString(1));
				bean.setCustid(rs.getInt(2));
				bean.setCustname(rs.getString(3));
				bean.setPrice(rs.getInt(4));
				bean.setReturnstatus(rs.getString(5));
				beans.add(bean);
			}
			rs.close();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beans;
	}
	
	public static int returnCar(String carno) {
		int status = 0;
		try {
			Connection con = DB.getCon();
			String updateQuery = "UPDATE RENTCAR2 SET RETURNSTAT = 'YES' WHERE CARNO = ?";
			PreparedStatement pst = con.prepareStatement(updateQuery);
			pst.setString(1, carno);
			status = pst.executeUpdate();
			if(status > 0) {
				String updateQuery2 = "UPDATE CAR2 SET CARSTATUS = 'YES' WHERE CARNO = ?";
				PreparedStatement pst2 = con.prepareStatement(updateQuery2);
				pst2.setString(1, carno);
				status = pst2.executeUpdate();
				pst2.close();
			}
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static int getPriceByCarNo(String carno) {
		int price = 0;
		try {
			Connection con = DB.getCon();
			String selectQuery = "SELECT CARPRICE FROM CAR2 WHERE CARNO = ?";
			PreparedStatement pst = con.prepareStatement(selectQuery);
			pst.setString(1, carno);;
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				price = rs.getInt(1);
			}
			rs.close();
			pst.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return price;
	}
}
