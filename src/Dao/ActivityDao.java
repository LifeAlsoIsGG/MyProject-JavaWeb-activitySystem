package Dao;

import java.io.*;
import java.sql.*;
import java.util.*;

import Dto.*;
import Tool.*;

public class ActivityDao {
	// Ѱ�һ�������ݻ�ͨ��aid��anameѰ�Ҳ������ͨ���������ӣ�i=1��ʱͨ��aid��ѯ��i=2��ͨ�����Ʋ����أ�i=3����ѯ���������������
	public void FindAll(int i) {
		Scanner in = new Scanner(System.in);
		String s = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();

			// ���ѯ��ʽ
			switch (i) {
			case 1:// ͨ���id��ѯ
				pstmt = conn
						.prepareStatement("select a.aid,a.aname,a.level,a.place,a.duration,c.pid,e.pname,e.phonenumber,c.con,c.nreason"
								+ " from Activity a left outer join Con c "
								+ " on a.aid = c.aid left outer join ExamineP e"
								+ " on e.pid=c.pid"
								+ " where a.deletemark =1 and a.aid = ?");
				System.out.print("���������ѯ�Ļid��");
				s = in.next();// ��ȡ��ѯid
				pstmt.setString(1, s);
				break;
			case 2:// ͨ������ֲ�ѯ
				pstmt = conn
						.prepareStatement("select a.aid,a.aname,a.level,a.place,a.duration,c.pid,e.pname,e.phonenumber,c.con,c.nreason"
								+ " from Activity a left outer join Con c "
								+ " on a.aid = c.aid left outer join ExamineP e"
								+ " on e.pid=c.pid"
								+ " where a.deletemark =1 and a.aname like ? ");
				System.out.print("���������ѯ�Ļ�ؼ��֣�");
				s = in.next();// ��ȡ��ѯ��
				s = "%" + s + "%";// �ؼ��ֲ�ѯ
				pstmt.setString(1, s);
				break;
			case 3:// ��ѯ����
				pstmt = conn
						.prepareStatement("select a.aid,a.aname,a.level,a.place,a.duration,c.pid,e.pname,e.phonenumber,c.con,c.nreason"
								+ " from Activity a left outer join Con c "
								+ " on a.aid = c.aid left outer join ExamineP e"
								+ " on e.pid=c.pid"
								+ " where a.deletemark =1 and a.aid in(select aid from Activity)");
				break;
			}
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rs.previous();
				System.out
						.println("-----------------------------------------------------------���л�����ѯ�ɹ�----------------------------------------------------------");
				System.out.println("����" + "  " + "\t" + " �����" + "  " + "\t"
						+ "����" + "  " + "\t" + " �ص�" + "  " + "\t"
						+ "                      " + "ʱ��" + "           "
						+ "\t" + " ����˱��" + "  " + "\t" + "���������" + "    "
						+ "�������ϵ��ʽ" + "   " + "\t" + " ���״̬" + "  " + "\t"
						+ " ���δͨ��ԭ��" + '\t');
				while (rs.next()) {
					System.out.print("#" + rs.getString("a.aid") + "  " + "\t");
					System.out.print(rs.getString("a.aname") + "  " + "\t");
					System.out.print(rs.getString("a.level") + "  " + "\t");
					System.out.print(rs.getString("a.place") + "\t" + "   ");
					System.out.print(rs.getString("a.duration") + "  "
							+ "\t   ");
					System.out.print(rs.getString("c.pid") + "\t        ");
					System.out.print(rs.getString("e.pname") + "\t     ");
					System.out.print(rs.getString("e.phonenumber") + "\t    ");
					System.out.print(rs.getString("c.con") + "  \t      ");
					System.out.println(rs.getString("c.nreason") + "\t");
				}
				rs.last();
				System.out
						.println("\n---------------------------------------------------------------��"
								+ rs.getRow()
								+ "����¼---------------------------------------------------------------\n");
			} else
				System.out.println("δ�ҵ���¼�������ʽ����");
			System.out.println();//
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
	}

	// ͨ��aid��ѯ�Ƿ���ڲ����
	public boolean FindActivityByaid(String _aid) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("select * from Activity where aid=? and deletemark =1");
			pstmt.setString(1, _aid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
				System.out.println("����" + "  " + "\t" + " �����" + "  " + "\t"
						+ "����" + "  " + "\t" + " �ص�" + "  " + "\t"
						+ "                      " + "ʱ��");
				System.out.print("#" + rs.getString("aid") + "  " + "\t");
				System.out.print(rs.getString("aname") + "  " + "\t");
				System.out.print(rs.getString("level") + "  " + "\t");
				System.out.print(rs.getString("place") + "\t" + "   ");
				System.out.println(rs.getString("duration") + "  " + "\t   ");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;
	}

	// ͨ��aname��ѯ�Ƿ����
	public boolean FindActivityByaname(String _aname) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("select * from Activity where aname=? and deletemark =1");
			pstmt.setString(1, _aname);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
				System.out.println("����" + "  " + "\t" + " �����" + "  " + "\t"
						+ "����" + "  " + "\t" + " �ص�" + "  " + "\t"
						+ "                      " + "ʱ��");
				System.out.print("#" + rs.getString("aid") + "  " + "\t");
				System.out.print(rs.getString("aname") + "  " + "\t");
				System.out.print(rs.getString("level") + "  " + "\t");
				System.out.print(rs.getString("place") + "\t" + "   ");
				System.out.println(rs.getString("duration") + "  " + "\t   ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;
	}

	//����aname�ؼ��ֲ�ѯ
	public Vector<ActivityDto> FindActivityByAnamekeyword(String _anamekeyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector<ActivityDto> v = new Vector<ActivityDto>();
		
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("select * from Activity where aname like ? and deletemark = 1");
			String s = '%'+ _anamekeyword+'%';
			pstmt.setString(1, s);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ActivityDto a = new ActivityDto();
				System.out.println("aid="+rs.getString("aid"));
/*				a.setAid(rs.getString("aid"));
				a.setAname(rs.getString("aname"));
				a.setLevel(rs.getString("level"));
				a.setPlace(rs.getString("place"));
				a.setDuration(rs.getString("duration"));
				a.setPname(rs.getString("pname"));
				a.setEmail(rs.getString("email"));
				a.setInf(rs.getString("inf"));
				a.setCon(rs.getString("con"));*/
				a.setAll(rs.getString("aid"), rs.getString("aname"), rs.getString("level"), rs.getString("place"), rs.getString("duration"), 
						rs.getString("pname"),rs.getString("email"), rs.getString("inf"), rs.getString("con"), "1");
				v.add(a);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return v;
	}	
	
	// ͨ��aname��ѯaid
	public String FindActivityAidByaname(String _aname) {
		String s = null ;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
				conn = DataAccess.getConnection();
				pstmt = conn.prepareStatement("select aid from Activity where aname=? and deletemark =1");
				pstmt.setString(1, _aname);
				rs = pstmt.executeQuery();
				if(rs.next())
					s = rs.getString("aid");
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DataClose.DataClose(rs, pstmt, conn);
			}
		return s;
	}
	
	// ��ѯ��������
	public Vector<ActivityDto> FindAllActivity() {
		Vector<ActivityDto> v = new Vector<ActivityDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("select * from Activity where deletemark = 1");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ActivityDto a = new ActivityDto();
				a.setAid(rs.getString("aid"));
				a.setAname(rs.getString("aname"));
				a.setLevel(rs.getString("level"));
				a.setPlace(rs.getString("place"));
				a.setDuration(rs.getString("duration"));
				a.setPname(rs.getString("pname"));
				a.setEmail(rs.getString("email"));
				a.setInf(rs.getString("inf"));
				a.setCon(rs.getString("con"));
				v.add(a);						
				} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return v;

	}

	// ��ѯ�������ɾ���Ļ��
	public Vector<ActivityDto> FindAllDelActivity() {
		Vector<ActivityDto> v = new Vector<ActivityDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("select * from Activity where deletemark = 0");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ActivityDto a = new ActivityDto();
				a.setAid(rs.getString("aid"));
				a.setAname(rs.getString("aname"));
				a.setLevel(rs.getString("level"));
				a.setPlace(rs.getString("place"));
				a.setDuration(rs.getString("duration"));
				a.setPname(rs.getString("pname"));
				a.setEmail(rs.getString("email"));
				a.setInf(rs.getString("inf"));
				a.setCon(rs.getString("con"));
				v.add(a);						
				} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return v;

	}
	
	// ���ػ���¼��
	public int GetRowForActivity() {
		int i = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("select * from Activity ");
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

	// ������
	public boolean InsertActivity(ActivityDto a) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("insert into Activity values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, a.getAid());
			pstmt.setString(2, a.getAname());
			pstmt.setString(3, a.getLevel());
			pstmt.setString(4, a.getPlace());
			pstmt.setString(5, a.getDuration());
			pstmt.setString(6, a.getPname());
			pstmt.setString(7, a.getEmail());
			pstmt.setString(8, a.getInf());
			pstmt.setString(9, a.getCon());
			pstmt.setString(10, a.getDeletemark());
			if (pstmt.executeUpdate() == 1)// ����ɹ��󷵻�1
				flag = true;
		} catch (final SQLException e) {
			e.printStackTrace();
		} finally {

			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;
	}

	// ����aidɾ�������ɾ���������¼
	public boolean DeleteActivityByaid(ActivityDto a) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			// ɾ����deletemark��Ϊ0����ɾ����������ɾ�����
			pstmt = conn
					.prepareStatement("update Activity set deletemark = 0 where aid=?");
			pstmt.setString(1, a.getAid());
			if (pstmt.executeUpdate() == 1)// ɾ���ɹ��󷵻�1
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;

	}

	// ����anameɾ�������ɾ���������¼
	public boolean DeleteActivityByaname(ActivityDto a) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			// ɾ����deletemark��Ϊ0����ɾ����������ɾ�����
			pstmt = conn
					.prepareStatement("update Activity set deletemark = 0 where aname like ?");
			pstmt.setString(1, a.getAname());
			if (pstmt.executeUpdate() == 1)// ɾ���ɹ��󷵻�1
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;

	}

	// ����aid����Activity
	public boolean UpdateActivityByaid(ActivityDto a) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			pstmt = conn
					.prepareStatement("update Activity set aname=?,pname=?,email=?,level=?,place=?,duration=?,inf=?,con=? where aid = ?");
			pstmt.setString(1, a.getAname());
			pstmt.setString(2, a.getPname());
			pstmt.setString(3, a.getEmail());
			pstmt.setString(4, a.getLevel());
			pstmt.setString(5, a.getPlace());
			pstmt.setString(6, a.getDuration());
			pstmt.setString(7, a.getInf());
			pstmt.setString(8, a.getCon());
			pstmt.setString(9, a.getAid());
			if (pstmt.executeUpdate() == 1)
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;

	}

	// ����aname����Activity
	public boolean UpdateActivityByaname(ActivityDto a) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess.getConnection();
			// ɾ����deletemark��Ϊ0����ɾ����������ɾ�����
			pstmt = conn
					.prepareStatement("update Activity set aname=?,level=?,place=?,duration=? where aname = ?");
			pstmt.setString(1, a.getAname());
			pstmt.setString(2, a.getLevel());
			pstmt.setString(3, a.getPlace());
			pstmt.setString(4, a.getDuration());
			pstmt.setString(5, a.getAname());
			if (pstmt.executeUpdate() == 1)// ɾ���ɹ��󷵻�1
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataClose.DataClose(rs, pstmt, conn);
		}
		return flag;

	}

}
