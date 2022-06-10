package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Dto.ActivityDto;
import Dto.UserDto;
import Tool.DataAccess;
import Tool.DataClose;

public class UserDao {
	//ͨ���û����������¼
	public int UserLogin(String _uname,String _password ) {
			int flag = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				pstmt = conn.prepareStatement("select * from User where deletemark = 1 and uname = ? and password = ?");
				pstmt.setString(1, _uname);
				pstmt.setString(2, _password);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					flag = rs.getInt("sSuper");
					System.out.println("-----------------------------------------------------------�û���Ϣ----------------------------------------------------------");
					System.out.println("�û�id" + "\t" + "�û�����" + "\t" + "����"+ "\t" + "Ȩ��" );
					System.out.print("#" + rs.getString("uid") + "\t");
					System.out.print(rs.getString("uname") + "\t  ");
					System.out.print(rs.getString("password") + "\t");
					System.out.println(rs.getString("sSuper") + "\t");
				} else
					System.out.println("��¼�����ڻ��������!");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DataClose.DataClose(rs, pstmt, conn);
			}
			return flag;
		}
		
	//���������û�
	public Vector<UserDto> AllUser( ) {
				Vector<UserDto> v = new Vector<UserDto>();
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					try {
						conn = DataAccess.getConnection();
						pstmt = conn.prepareStatement("select * from User where deletemark = 1");
						rs = pstmt.executeQuery();
						while(rs.next()) {
							UserDto u = new UserDto();
							u.setUid(rs.getString("uid"));
							u.setUname(rs.getString("uname"));
							u.setPassword(rs.getString("password"));
							u.setsSuper(rs.getInt("sSuper"));
							v.add(u);						
							} 
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						DataClose.DataClose(rs, pstmt, conn);
					}
					return v;
				}

	//�������б�ɾ�����û�
	public Vector<UserDto> AllDelUser( ) {
		Vector<UserDto> v = new Vector<UserDto>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				pstmt = conn.prepareStatement("select * from User where deletemark = 0");
				rs = pstmt.executeQuery();
				while(rs.next()) {
					UserDto u = new UserDto();
					u.setUid(rs.getString("uid"));
					u.setUname(rs.getString("uname"));
					u.setPassword(rs.getString("password"));
					u.setsSuper(rs.getInt("sSuper"));
					v.add(u);						
					} 
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DataClose.DataClose(rs, pstmt, conn);
			}
			return v;
		}	
	//ͨ��Uname��ѯ��ע�����µ�ʱ���ж�
	public boolean FindByUname( String _Uname) {
			boolean flag = false;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				pstmt = conn.prepareStatement("select * from User where   uname =?");
				pstmt.setString(1,_Uname);
				rs = pstmt.executeQuery();
				if(rs.next())
					flag = true;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DataClose.DataClose(rs, pstmt, conn);
			}
			return flag;
		}
	
	//���ҳ�Uname�����Ƿ���ͬ����
	public boolean FindElseByUname( String _Uname) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn.prepareStatement("select * from User where  uname !=?");
			pstmt.setString(1,_Uname);
			rs = pstmt.executeQuery();
			if(rs.next())
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;
	}

	//�����û����е����֣������Ȩ��
	public boolean UpdateUser(UserDto u) {
			boolean flag = false;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				pstmt = conn
						.prepareStatement("update User set uname=?,password=?,sSuper=? where uid = ?");
				pstmt.setString(1, u.getUname());
				pstmt.setString(2, u.getPassword());
				pstmt.setInt(3, u.getsSuper());
				pstmt.setString(4, u.getUid());

				if (pstmt.executeUpdate() == 1)
					flag = true;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DataClose.DataClose(rs, pstmt, conn);
			}
			return flag;

		}	
		
	//�����û�uid��ɾ���û�
	public boolean DeleteUserByuid(UserDto u) {
			boolean flag = false;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				//
				pstmt = conn.prepareStatement("update User set deletemark = 0 where uid=?");
				pstmt.setString(1, u.getUid());
				if (pstmt.executeUpdate() == 1)// ɾ���ɹ��󷵻�1
					flag = true;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DataClose.DataClose(rs, pstmt, conn);
			}
			return flag;

		}
	//�����û�uid��ɾ���û�
		public boolean DeleteUserByUname(UserDto u) {
				boolean flag = false;
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = DataAccess.getConnection();
					//
					pstmt = conn.prepareStatement("update User set deletemark = 0 where uname=?");
					pstmt.setString(1, u.getUname());
					if (pstmt.executeUpdate() == 1)// ɾ���ɹ��󷵻�1
						flag = true;
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					DataClose.DataClose(rs, pstmt, conn);
				}
				return flag;

			}	
	//�����û�uid������ɾ���û�
	public boolean DeleteUserByaid(String sql) {
				boolean flag = false;
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					conn = DataAccess.getConnection();
					//
					pstmt = conn.prepareStatement("update User set deletemark = 0 where uid in (?)");
					pstmt.setString(1, sql);
					if (pstmt.executeUpdate() == 1)// ɾ���ɹ��󷵻�1
						flag = true;
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					DataClose.DataClose(rs, pstmt, conn);
				}
				return flag;

			}
	
	//�û�ע�ᣬ����
	public boolean InsertUser(UserDto u) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			
			pstmt = conn
					.prepareStatement("insert into User values(?,?,?,?,?)");
			pstmt.setString(1, u.getUid());
			pstmt.setString(2, u.getUname());
			pstmt.setString(3, u.getPassword());
			pstmt.setInt(4, u.getsSuper());
			pstmt.setInt(5, 1);
			if (pstmt.executeUpdate() == 1)// ����ɹ��󷵻�1
				flag = true;
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {

			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;
	}

	// �����û����¼��
	public int GetRowForUser() {
			int i = 0;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				conn = DataAccess.getConnection();
				pstmt = conn
						.prepareStatement("select * from User ");
				rs = pstmt.executeQuery();
				rs.last();
				i = rs.getRow();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DataClose.DataClose(rs, pstmt, conn);
			}
			return i;
		}
}
