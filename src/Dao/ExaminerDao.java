package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Dto.ActivityDto;
import Dto.ExaminerDto;
import Dto.UserDto;
import Tool.DataAccess;
import Tool.DataClose;

public class ExaminerDao {

	// ͨ��eid��ѯ,����ֵΪboolean
	public boolean FindExaminerByeid(String _eid) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("select * from Examiner where deletemark = 1 and eid=?");
			pstmt.setString(1, _eid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
				System.out
						.println("-----------------------------------------------------------ͨ�������id��ѯ�ɹ�----------------------------------------------------------");
				System.out.println("�����id" + "\t" + "���������" + "\t" + "����"
						+ "\t" + "��ϵ����" + "\t");
				System.out.print("#" + rs.getString("eid") + "\t");
				System.out.print(rs.getString("ename") + "\t                ");
				System.out.print(rs.getString("level") + "\t");
				System.out.println(rs.getString("phonenumber") + "\t");
				rs.last();
				System.out
						.println("\n------------------------------------------------------------��"
								+ rs.getRow()
								+ "����¼------------------------------------------------------------------\n");
			} else
				System.out.println("��¼δ�ҵ��������ʽ���󣨲�ѯid�����ʽΪ��p01��p02�ȣ�!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;
	}

	// ͨ��ename��ѯ,����ֵΪboolean
	public boolean FindExaminerByename(String _ename) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("����Ename�Ƿ�����ǣ����������ename="+_ename);
		try {
			conn = DataAccess.getConnection();
			pstmt = conn.prepareStatement("select * from Examiner where deletemark = 1 and ename =?");
			pstmt.setString(1, _ename);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
				System.out.println("-----------------------------------------------------------ͨ����������ֲ�ѯ�ɹ�----------------------------------------------------------");
				System.out.println("�����id" + "\t" + "���������" + "\t" + "����"+ "\t" + "��ϵ����" + "\t");
				System.out.print("#" + rs.getString("eid") + "\t");
				System.out.print(rs.getString("ename") + "\t                ");
				System.out.print(rs.getString("level") + "\t");
				System.out.println(rs.getString("phonenumber") + "\t");
			} else
				System.out.println("��¼δ�ҵ��������ʽ����!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;
	}

	// ��ѯ�����������Ϣ,����Vector����
	public Vector<ExaminerDto> FindAllExaminer() {
		Vector<ExaminerDto> v = new Vector<ExaminerDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String s;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn.prepareStatement("select * from Examiner where deletemark = 1");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ExaminerDto e = new ExaminerDto();
				e.setEid(rs.getString("eid"));
				e.setEname(rs.getString("ename"));
				e.setName(rs.getString("Name"));
				e.setLevel(rs.getString("level"));
				e.setPhonenumber(rs.getString("phonenumber"));
				v.add(e);						
				} 
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return v;
	}
	
	// ��ѯ�����������Ϣ,����Vector����
		public Vector<ExaminerDto> FindAllDelExaminer() {
			Vector<ExaminerDto> v = new Vector<ExaminerDto>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String s;
			try {
				conn = DataAccess.getConnection();
				pstmt = conn.prepareStatement("select * from Examiner where deletemark = 0");
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					ExaminerDto e = new ExaminerDto();
					e.setEid(rs.getString("eid"));
					e.setEname(rs.getString("ename"));
					e.setName(rs.getString("Name"));
					e.setLevel(rs.getString("level"));
					e.setPhonenumber(rs.getString("phonenumber"));
					v.add(e);						
					} 
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DataClose.DataClose(rs, pstmt, conn);
			}
			return v;
		}	

	// ͨ��ename��ѯeid
	public String FindEidByEname(String _ename) {
		String eid = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn.prepareStatement("select eid from Examiner where name=?");
			pstmt.setString(1, _ename);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				eid = rs.getString("ename");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return eid;
	}
	
	
	// ��������˱��¼��
	public int GetRowForExaminer() {
		int i = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("select * from Examiner ");
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

	// ��������˱�
	public boolean InsertExaminer(ExaminerDto e) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("insert into Examiner values(?,?,?,?,?,?)");
			pstmt.setString(1, e.getEid());
			pstmt.setString(2, e.getEname());
			pstmt.setString(3, e.getName());
			pstmt.setString(4, e.getLevel());
			pstmt.setString(5, e.getPhonenumber());
			pstmt.setString(6, e.getDeletemark());
			if (pstmt.executeUpdate() == 1)// ����ɹ��󷵻�1
				flag = true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;
	}

	// ����eidɾ�������ɾ���������¼���������˼�¼
	public boolean DeleteExaminerByeid(ExaminerDto e) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			// ɾ����deletemark��Ϊ0����ɾ����������ɾ�����
			pstmt = conn
					.prepareStatement("update 	Examiner set deletemark = 0 where eid=?");
			pstmt.setString(1, e.getEid());
			if (pstmt.executeUpdate() == 1)// ɾ���ɹ��󷵻�1
				flag = true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;

	}

	// ����enameɾ�������ɾ���������¼���������˼�¼
	public boolean DeleteExaminerByename(ExaminerDto e) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			// ɾ����deletemark��Ϊ0����ɾ����������ɾ�����
			pstmt = conn
					.prepareStatement("update 	Examiner set deletemark = 0 where ename=?");
			pstmt.setString(1, e.getEname());
			if (pstmt.executeUpdate() == 1)// ɾ���ɹ��󷵻�1
				flag = true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;
	}

	// ����eid��������˱�,��������,����,�绰����
	public boolean UpdateExaminerByeid(ExaminerDto e) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn.prepareStatement("update Examiner set name=?, level=?,phonenumber=? where eid = ? and deletemark = 1");
			pstmt.setString(1, e.getName());
			pstmt.setString(2, e.getLevel());
			pstmt.setString(3, e.getPhonenumber());
			pstmt.setString(4, e.getEid());
			if (pstmt.executeUpdate() == 1)// ���³ɹ��󷵻�1
				flag = true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;

	}

	// ����ename��������˱�
	public boolean UpdateExaminerEnameByEname(String _NewEname,String _OldEname) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			// ɾ����deletemark��Ϊ0����ɾ����������ɾ�����
			pstmt = conn.prepareStatement("update Examiner set ename=? where ename = ? and deletemark = 1");
			pstmt.setString(1, _NewEname);
			pstmt.setString(2,_OldEname);

			System.out.println(pstmt.executeUpdate());
			if (pstmt.executeUpdate() == 1)// ���³ɹ��󷵻�1
				flag = true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;

	}
	

	
}
