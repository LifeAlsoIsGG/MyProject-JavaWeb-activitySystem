package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Dto.ActivityDto;
import Dto.ConDto;
import Dto.ExaminerDto;
import Tool.DataAccess;
import Tool.DataClose;

public class ConDao {
	
	// ��ѯ����������
	public Vector<ConDto> FindAllCondition() {
		Vector<ConDto> v = new Vector<ConDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String s;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn.prepareStatement("select * from Con where deletemark = 1");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ConDto c = new ConDto();
				c.setAid(rs.getString("aid"));
				c.setAname(rs.getString("aname"));
				c.setName(rs.getString("name"));
				c.setLevel(rs.getString("level"));
				c.setCon(rs.getString("con"));
				c.setNreason(rs.getString("nreason"));
				v.add(c);						
				} 
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return v;
	}

	// ��ѯ���б�ɾ����������
		public Vector<ConDto> FindAlDelCondition() {
			Vector<ConDto> v = new Vector<ConDto>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String s;
			try {
				conn = DataAccess.getConnection();
				pstmt = conn.prepareStatement("select * from Con where deletemark = 0");
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					ConDto c = new ConDto();
					c.setAid(rs.getString("aid"));
					c.setAname(rs.getString("aname"));
					c.setName(rs.getString("name"));
					c.setLevel(rs.getString("level"));
					c.setCon(rs.getString("con"));
					c.setNreason(rs.getString("nreason"));
					v.add(c);						
					} 
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DataClose.DataClose(rs, pstmt, conn);
			}
			return v;
		}	
	// ͨ��id�����ֲ���
	public void FindAllConditionByaidAndeid() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String s;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("select a.aid,a.aname,c.eid,e.ename,a.level,c.con,c.nreason    "
							+ "from Activity a left outer join Con c   "
							+ " on a.aid = c.aid left outer join ExamineP e on e.eid=c.eid "
							+ " where a.deletemark =1 and a.aid in(select aid from Activity)");
			rs = pstmt.executeQuery();
			System.out
					.println("-----------------------------------------------------------��ѯ���������ѯ�ɹ�----------------------------------------------------------");
			System.out.println("�id" + "\t" + "�����" + "    \t" + "�����id"
					+ "\t" + "���������" + "\t" + "����" + "\t" + "������" + "\t"
					+ "δͨ��ԭ��" + "\t");
			if (rs.next()) {
				rs.previous();
				while (rs.next()) {
					System.out.print("#" + rs.getString("aid") + "\t");
					System.out.print(rs.getString("aname") + "\t");
					System.out.print(rs.getString("eid") + "\t");
					System.out.print(rs.getString("ename")
							+ "\t                ");
					System.out.print(rs.getString("level") + "\t");
					System.out.print(rs.getString("con") + "\t");
					System.out.println(rs.getString("nreason") + "\t");
				}
				rs.last();
				System.out
						.println("\n------------------------------------------------------------��"
								+ rs.getRow()
								+ "����¼------------------------------------------------------------------\n");
			} else
				System.out.println("��¼Ϊ�գ�");
			System.out.println();//

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
	}

	// ͨ��aid��ѯ�Ƿ����
	public boolean FindConditionByaid(String _aid) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn.prepareStatement("select * from Con where aid=?");
			pstmt.setString(1, _aid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
				System.out.println("�id" + "\t" + "�����id" + "\t" + "���������"
						+ "\t" + "����" + "\t" + "������" + "\t" + "δͨ��ԭ��" + "\t");
				System.out.print("#" + rs.getString("aid") + "  " + "\t");
				System.out.print(rs.getString("eid") + "  " + "\t");
				System.out.print(rs.getString("level") + "  " + "\t");
				System.out.print(rs.getString("con") + "\t" + "   ");
				System.out.println(rs.getString("nreason") + "  " + "\t   ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;
	}

	// ͨ��eid��ѯ�Ƿ����
	public boolean FindConditionByeid(String _eid) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn.prepareStatement("select * from Con where eid=?");
			pstmt.setString(1, _eid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
				System.out.println("�id" + "\t" + "�����id" + "\t" + "���������"
						+ "\t" + "����" + "\t" + "������" + "\t" + "δͨ��ԭ��" + "\t");
				System.out.print("#" + rs.getString("aid") + "  " + "\t");
				System.out.print(rs.getString("eid") + "  " + "\t");
				System.out.print(rs.getString("level") + "  " + "\t");
				System.out.print(rs.getString("con") + "\t" + "   ");
				System.out.println(rs.getString("nreason") + "  " + "\t   ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;
	}
	



	// ���ӻ������ӻ��������
	public boolean InsertActivityAndCon(ActivityDto a) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("insert into Con values(?,'null',?,'�����','null',?)");
			pstmt.setString(1, a.getAid());
			pstmt.setString(2, a.getLevel());
			pstmt.setString(3, a.getDeletemark());
			if (pstmt.executeUpdate() == 1)// ����ɹ��󷵻�1
				flag = true;
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;
	}

	// ͨ��aidɾ��������
	public boolean DeleteConByaid(ConDto c) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("update Con set deletemark = 0 where aid=?");
			pstmt.setString(1, c.getAid());
			if (pstmt.executeUpdate() == 1)// ɾ���ɹ��󷵻�1
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;

	}

	// ͨ��anameɾ��������
	public boolean DeleteConByaname(ConDto c) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("update Con set deletemark = 0 where aname like ?");
			pstmt.setString(1, c.getAname());
			if (pstmt.executeUpdate() == 1)// ɾ���ɹ��󷵻�1
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;

	}

	// ͨ��eidɾ��������
	/*public boolean DeleteConByeid(ConDto c) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("update Con set eid=null where eid=?");
			pstmt.setString(1, c.getEid());
			if (pstmt.executeUpdate() == 1)// ɾ���ɹ��󷵻�1
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;

	}*/

	// ͨ��enameɾ��������
	public boolean DeleteConByename(ConDto c) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("update Con set eid=null where ename = ?");
			pstmt.setString(1, c.getName());
			if (pstmt.executeUpdate() == 1)// ɾ���ɹ��󷵻�1
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;

	}

	// ͨ��aid����
	public boolean UpdateConByaid(ConDto c) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			// ɾ����deletemark��Ϊ0����ɾ����������ɾ�����
			pstmt = conn.prepareStatement("Update Con set name=? ,level=?,con=?,nreason=? where aid=?");
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getLevel());
			pstmt.setString(3, c.getCon());
			pstmt.setString(4, c.getNreason());
			pstmt.setString(5, c.getAid());
			if (pstmt.executeUpdate() == 1)// 
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;

	}

}
