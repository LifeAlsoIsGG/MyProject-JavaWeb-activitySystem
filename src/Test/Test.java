/*package Test;

import java.io.ObjectInputStream.GetField;
import java.sql.*;
import java.util.*;

import javax.print.attribute.standard.Finishings;

import Dao.*;//Dao������
import Dto.*;//Dto������
import Tool.*;//����������

public class Test {

	// һ���˵�Ŀ¼
	public static void catalog() {
		System.out.println("***************һ���˵�Ŀ¼****************");
		System.out.println("*1.��ѯ��¼\n*2.���Ӽ�¼\n*3.ɾ����¼\n*4.���¼�¼\n*0.�˳�ϵͳ");
		System.out.println("��ѡ��������ķ���");
		System.out.println("*****************************************");

	}

	// �����˵���ѯĿ¼
	public static void Level2ForSearch() {
		System.out.println("\n***************�����˵���ѯĿ¼*************");
		System.out.println("1.����˲�ѯ\n2.���ѯ\n3.���������ѯ\n4.����һ���˵�\n0.�˳�ϵͳ");
		System.out.println("��ѡ��������ķ���");
		System.out.println("*****************************************");
	}

	// �����˵�����Ŀ¼
	public static void Level2ForAdd() {
		System.out.println("\n***************�����˵�����Ŀ¼*************");
		System.out.println("1.���ӻ��\n2.��������˱�\n3.���ӻ�����\n4.����һ���˵�\n0.�˳�ϵͳ");
		System.out.println("��ѡ��������ķ���");
		System.out.println("*****************************************");
	}

	// �����˵�ɾ��Ŀ¼
	public static void Level2ForDelete() {
		System.out.println("\n***************�����˵�ɾ��Ŀ¼*************");
		System.out.println("1.ɾ�����\n2.ɾ������˱�\n3.����һ���˵�\n0.�˳�ϵͳ");
		System.out.println("��ѡ��������ķ���");
		System.out.println("*****************************************");
	}

	// �����˵�����Ŀ¼
	public static void Level2ForUpdate() {
		System.out.println("***************�����˵�����Ŀ¼*************");
		System.out.println("1.���»��\n2.��������˱�\n3.���»��������\n4.����һ���˵�\n0.�˳�ϵͳ");
		System.out.println("��ѡ��������ķ���");
		System.out.println("*****************************************");
	}

	// �¼�����
	public static void Event(int select1) {
		ActivityDao a = new ActivityDao();
		ExaminerDao e = new ExaminerDao();
		ConDao c = new ConDao();

		ActivityDto aDto = new ActivityDto();// ���ڲ���,ɾ���Ȼ�����
		ExaminerDto eDto = new ExaminerDto();// ���ڲ���,ɾ��������˱����
		ConDto cDto = new ConDto();// ���ڲ���,ɾ��������˱����

		Scanner in = new Scanner(System.in);
		String s;
		// һ���˵�ѭ��
		while (select1 != 0) {
			int select2 = 1;// �����˵���ѡ��
			int select3 = 1;// �����˵���ѡ��
			catalog();
			select1 = in.nextInt();
			switch (select1) {// һ���˵�ѡ��
			// --------------------------------------------------------------һ���˵�:��ѯ��¼-----------------------------------------------------
			case 1:
				// �����˵���ѯ��¼������˲�ѯ
				while (select2 != 4 && select2 != 0 && select3 != 0) {// ��select2Ϊ0��select3Ϊ0ʱ�Ƴ�����ѭ��
					Level2ForSearch();// �����˵���ѯĿ¼
					select2 = in.nextInt();
					switch (select2) {
					// ����˱��ѯ
					case 1:// �����˵���˱��ѯ
						System.out
								.println("\n************�����˵�����˱��ѯĿ¼*********");
						System.out
								.println("1.ͨ�������������ѯ\n2.ͨ�������id��ѯ\n3.��������˲�ѯ\n4.���ض����˵�\n0.�˳�ϵͳ");
						System.out.println("����ͨ��ʲô����ѯ��");
						System.out
								.println("*****************************************");
						select3 = in.nextInt();
						// ͨ�������id��ѯ
						if (select3 == 1) {
							System.out.println("�����������������������ؼ��ֲ�ѯ����");
							s = in.next();
							e.FindExaminePBypname(s);
						}

						// ͨ�����������
						else if (select3 == 2) {
							System.out.println("�����������id����ʽΪp01,p02����");
							s = in.next();
							e.FindExaminePBypid(s);
						}
						// ��ѯ���������
						else if (select3 == 3) {
							e.FindAllExamineP();
						}
						// ���ض����˵�
						else if (select3 == 4)
							break;
						// �˳�ϵͳ
						else if (select3 == 0)
							break;
						else
							System.out.println("������Ĳ��������������������룡");

						break;

					case 2:// �����˵���ѯ��¼��������ѯ
						System.out
								.println("\n***********�����˵��������ѯĿ¼*********");
						System.out
								.println("1.ͨ���id����\n2.ͨ������ƹؼ��ֲ�ѯ\n3.��ѯ���л��Ϣ\n4.���ض�����ѯ�˵�\n0.�˳�ϵͳ");
						System.out.println("����ͨ��ʲô����ѯ��");
						System.out
								.println("*****************************************");
						select3 = in.nextInt();

						if (select3 == 1 || select3 == 2 || select3 == 3)
							a.FindAll(select3);
						if (select3 == 4)// ���ض����˵�
							break;
						else if (select3 == 0)// �˳�ϵͳ
							break;

						else
							System.out.println("������Ĳ��������������������룡");
						break;

					case 3:// �����˵���ѯ����������ѯ
						c.FindAllCondition();
						break;

					case 4:// ����һ���˵�
						break;

					case 0:// �˳�ϵͳ
						break;

					default:
						System.out.println("������Ĳ��������������������룡");
						break;

					}// switch(select2����)

				}// while(select2)ĩβ

				break;// һ���˵�case1����

			// --------------------------------------------------------------һ���˵�:���Ӽ�¼-----------------------------------------------------
			case 2:
				// �����˵�����ѭ��
				while (select2 != 4 && select2 != 0) {
					Level2ForAdd();// �����˵�����Ŀ¼
					select2 = in.nextInt();
					String s1, s2, s3, s4, s5;

					switch (select2) {
					// ������Ӽ�¼
					case 1:
						int ra = a.GetRowForActivity();// ������ݿ��б��¼��
						System.out
								.println("***************���ӻ��*******************");
						if (ra < 9)// ���ݻ�����Զ����û���
							s1 = "a0" + (ra + 1);
						else
							s1 = "a" + (ra + 1);
						aDto.setAid(s1);
						System.out.println("���������ƣ�");
						s2 = in.next();
						System.out.println("��ӵĻ����Ϊ��" + s2);

						System.out.println("����������Ժ�������ţ�У������");

						while ((s3 = in.next()) != null) {
							if (s3.equals("����") || s3.equals("Ժ��")
									|| s3.equals("У��"))
								break;
							else
								System.out
										.println("��ӵĻ�����ʽ�������������루��ʽΪ��Ժ�������ţ�У������");

						}
						System.out.println("��ӵĻ����Ϊ��" + s3);

						System.out.println("�������ص㣺");
						s4 = in.next();
						System.out.println("��ӵĻ�ص�Ϊ��" + s4);

						System.out.println("��������ʼ�ͽ���ʱ�䣺");
						s5 = in.next();
						System.out.println("��ӵĻ��ʼ����ʱ��Ϊ��" + s5);

						aDto.setLevel(s3);
						aDto.setAname(s2);
						aDto.setPlace(s4);
						aDto.setDuration(s5);
						aDto.setDeletemark("1");// ɾ�����
						// �����Ӻ�����ӻ��˱�
						if (a.InsertActivity(aDto) == true
								&& c.InsertActivityAndCon(aDto) == true) {// ����ɹ�ʱ
							System.out
									.println("----------------------------------------------------------------����ɹ�----------------------------------------------------------");
							a.FindAllActivity();// ������б�
							a.FindAll(3);// ���������
						} else
							System.out.println("����ʧ�ܣ���ע������ʽ�����²���");

						// ����˱����Ӽ�¼
					case 2:

						int re = e.GetRowForExamineP();// ������ݿ��б��¼��
						System.out
								.println("***************��������˱�******************");
						if (re < 9)// ���ݻ�����Զ����û���
							s1 = "p0" + (re + 1);
						else
							s1 = "p" + (re + 1);
						eDto.setPid(s1);
						System.out.println("�����������������");
						s2 = in.next();
						System.out.println("��ӵ����������Ϊ��" + s2);

						System.out.println("����������˼��𣨲��ţ�Ժ����У������");

						while ((s3 = in.next()) != null) {
							if (s3.equals("����") || s3.equals("Ժ��")
									|| s3.equals("У��"))
								break;
							else
								System.out
										.println("��ӵ�����˼����ʽ�������������루��ʽΪ��Ժ�������ţ�У������");

						}
						System.out.println("��ӵ�����˼���Ϊ��" + s3);

						System.out.println("�������������ϵ�绰��");
						s4 = in.next();
						System.out.println("��ӵ��������ϵ�绰Ϊ��" + s4);

						eDto.setPname(s2);
						eDto.setLevel(s3);
						eDto.setPhonenumber(s4);
						eDto.setDeletemark("1");// �Ƿ�ɾ�����
						if (e.InsertExamineP(eDto) == true) {// ����ɹ�ʱ
							System.out
									.println("----------------------------------------------------------------����ɹ�----------------------------------------------------------");
							e.FindAllExamineP();// �����������˱�
						} else
							System.out.println("����ʧ�ܣ���ע������ʽ�����²���");

						break;

					// �����������
					case 3:
						System.out.println("����Ȩ�޲������޷����в�������ѡ������������");
						break;

					case 4:// ����һ���˵�
						break;

					case 0:// �˳�ϵͳ
						break;

					default:
						System.out.println("������Ĳ��������������������룡");
						break;

					}// switch(select2����)

				}// while(select2)ĩβ

				break;// һ���˵�case1����

			// --------------------------------------------------------------һ���˵���ɾ����¼-----------------------------------------------------
			case 3:
				// �����˵�ɾ��ѭ��
				while (select2 != 3 && select2 != 0 && select3 != 0) {
					Level2ForDelete();// �����˵�ɾ��Ŀ¼
					select2 = in.nextInt();
					String s1, s2, s3, s4, s5;

					switch (select2) {

					// ���ɾ����¼
					case 1:
						System.out
								.println("\n************�����˵�ɾ�����Ŀ¼***********");
						System.out
								.println("1.ͨ���aidɾ��\n2.ͨ�������(ȫ��)ɾ��\n3.���ض���ɾ���˵�\n0.�˳�ϵͳ");
						System.out.println("����ͨ��ʲô��ɾ����");
						System.out
								.println("*****************************************");
						select3 = in.nextInt();
						// ͨ��aid��ѯ
						if (select3 == 1) {
							System.out.println("��������Ҫɾ���Ļaid����ʽΪ��a01,a02�ȣ���");
							s = in.next();
							aDto.setAid(s);
							cDto.setAid(s);
							System.out
									.println("------------------------------------------------------------����ɾ���ļ�¼Ϊ-----------------------------------------------------");
							if (a.FindActivityByaid(s) == false)// �����¼������FindAllActivityByaid���治����������������������Ҫɾ���ļ�¼
								System.out.println("����ɾ����aid=" + s
										+ "�ļ�¼�����ڣ�������ѡ�������");
							else {
								// ��ɾ����������ɾ�����
								if (c.DeleteConByaid(cDto) == true
										&& a.DeleteActivityByaid(aDto) == true) {
									System.out
											.println("---------------------------------------------------------------ɾ���ɹ�--------------------------------------------------------");
									a.FindAllActivity();// ���ɾ����Ļ��
									a.FindAll(3);
								} else
									System.out.println("ɾ��ʧ�ܣ�������ѡ�������");
							}
						}

						// ͨ�������ɾ��
						else if (select3 == 2) {
							System.out.println("��������Ҫɾ���Ļ���ƣ�ȫ������");
							s = in.next();
							aDto.setAname(s);
							cDto.setAid(a.FindActivityAidByaname(s));//����con��û��aname���ԣ�����ֻ����ͨ��aname�ҵ�aid�ڽ���ɾ��
							System.out
									.println("------------------------------------------------------------����ɾ���ļ�¼Ϊ-----------------------------------------------------");
							if (a.FindActivityByaname(s) == false)// �����¼������FindAllActivityByaname���治����������������������Ҫɾ���ļ�¼
								System.out.println("����ɾ����aname=" + s
										+ "�ļ�¼�����ڣ�������ѡ�������");
							else {
								// ��ɾ����������ɾ�����
								if (c.DeleteConByaid(cDto) == true&& a.DeleteActivityByaname(aDto) == true) {
									System.out
											.println("--------------------------------------------------------------ɾ���ɹ�----------------------------------------------------------");
									a.FindAllActivity();// ���ɾ����Ļ��
									a.FindAll(3);
								} else
									System.out.println("ɾ��ʧ�ܣ�������ѡ�������");
							}
						}

						// ���ض����˵�
						else if (select3 == 3)
							break;
						// �˳�ϵͳ
						else if (select3 == 0)
							break;
						else
							System.out.println("������Ĳ��������������������룡");

						break;

					// ����˱�ɾ����¼
					case 2:
						System.out
								.println("\n************�����˵�ɾ������˱�Ŀ¼**********");
						System.out
								.println("1.ͨ�������pidɾ��\n2.ͨ�����������ɾ��\n3.���ض���ɾ���˵�\n0.�˳�ϵͳ");
						System.out.println("����ͨ��ʲô��ɾ����");
						System.out
								.println("******************************************");

						select3 = in.nextInt();
						// ͨ�������idɾ��
						if (select3 == 1) {
							System.out.println("��������Ҫɾ���������pid����ʽΪp01��p02�ȣ���");
							s = in.next();
							eDto.setPid(s);
							cDto.setPid(s);
							System.out
									.println("------------------------------------------------------------����ɾ���ļ�¼Ϊ-----------------------------------------------------");
							if (e.FindExaminePBypid(s) == false)// �����¼������FindByPid���治����������������������Ҫɾ���ļ�¼
								System.out.println("����ɾ����pid=" + s
										+ "�ļ�¼�����ڣ�������ѡ�������");
							else {
								// ��ɾ����������ɾ�����
								if (c.DeleteConBypid(cDto) == true
										&& e.DeleteExaminePBypid(eDto) == true) {
									System.out
											.println("---------------------------------------------------------------ɾ���ɹ�--------------------------------------------------------");
									e.FindAllExamineP();// ���ɾ����Ļ��
									a.FindAll(3);
								} else
									System.out.println("ɾ��ʧ�ܣ�������ѡ�������");
							}
						}

						// ͨ�����������ɾ��
						else if (select3 == 2) {
							System.out.println("��������Ҫɾ������������֣�ȫ������");
							s = in.next();
							eDto.setPname(s);
							cDto.setPid(e.FindExaminePPidBypname(s));//����Con��û��pname���ԣ�����Ҫ��ͨ��pname�ҵ�pid��ɾ��
							System.out
									.println("------------------------------------------------------------����ɾ���ļ�¼Ϊ-----------------------------------------------------");
							if (e.FindExaminePBypname(s) == false)// �����¼������
								System.out.println("����ɾ����pname=" + s
										+ "�ļ�¼�����ڣ�������ѡ�������");
							else {
								// ��ɾ����������ɾ�����
								if (c.DeleteConBypid(cDto) == true
										&& e.DeleteExaminePBypname(eDto) == true) {
									System.out
											.println("--------------------------------------------------------------ɾ���ɹ�----------------------------------------------------------");
									e.FindAllExamineP();// ���ɾ����Ļ��
									a.FindAll(3);
								} else
									System.out.println("ɾ��ʧ�ܣ�������ѡ�������");
							}
						}

						// ���ض����˵�
						else if (select3 == 3)
							break;
						else if (select3 == 0)
							break;

						else
							System.out.println("������Ĳ��������������������룡");

						break;

					// ����һ���˵�
					case 3:
						break;

					case 0:// �˳�ϵͳ
						break;

					default:
						System.out.println("������Ĳ��������������������룡");
						break;

					}// switch(select2����)

				}// while(select2)ĩβ

				break;// һ���˵�case1����

			// --------------------------------------------------------------һ���˵�:���¼�¼-----------------------------------------------------
			case 4:
				// �����˵�����ѭ��
				while (select2 != 4 && select2 != 0 && select3 != 0) {
					Level2ForUpdate();// �����˵�����Ŀ¼
					select2 = in.nextInt();
					String s1, s2, s3, s4, s5;

					switch (select2) {
					// �����¼�¼
					case 1:
						System.out
								.println("\n************�����˵����»��Ŀ¼***********");
						System.out
								.println("1.ͨ���aid����\n2.ͨ�������(ȫ��)����\n3.���ض������²˵�\n0.�˳�ϵͳ");
						System.out.println("����ͨ��ʲô�����£�");
						System.out
								.println("*****************************************");
						select3 = in.nextInt();
						// ͨ��aid����
						if (select3 == 1) {
							System.out.println("��������Ҫ���µĻaid����ʽΪa01��a02�ȣ���");
							s = in.next();
							aDto.setAid(s);
							System.out
									.println("------------------------------------------------------------�������µļ�¼Ϊ-----------------------------------------------------");
							if (a.FindActivityByaid(s) == false)// �����¼������FindByPid���治����������������������Ҫɾ���ļ�¼
								System.out.println("������µ�aid=" + s
										+ "�ļ�¼�����ڣ�������ѡ�������");
							else {
								System.out
										.println("*****************���»��*****************");
								System.out.println("��������º�Ļ���ƣ�");
								s2 = in.next();
								System.out.println("���µĻ����Ϊ��" + s2);

								System.out.println("��������º�Ļ����Ժ�������ţ�У������");
								while ((s3 = in.next()) != null) {
									if (s3.equals("����") || s3.equals("Ժ��")
											|| s3.equals("У��"))
										break;
									else
										System.out
												.println("����Ļ�����ʽ�������������루��ʽΪ��Ժ�������ţ�У������");

								}
								System.out.println("���µĻ����Ϊ��" + s3);

								System.out.println("��������º�Ļ�ص㣺");
								s4 = in.next();
								System.out.println("���µĻ�ص�Ϊ��" + s4);

								System.out.println("��������º�Ļ��ʼ�ͽ���ʱ�䣺");
								s5 = in.next();
								System.out.println("���µĻ��ʼ����ʱ��Ϊ��" + s5);

								aDto.setAname(s2);
								aDto.setLevel(s3);
								aDto.setPlace(s4);
								aDto.setDuration(s5);
								if (a.UpdateActivityByaid(aDto) == true) {
									System.out
											.println("---------------------------------------------------------------���³ɹ�--------------------------------------------------------");
									a.FindAllActivity();
									;// ���ɾ����Ļ��
									a.FindAll(3);
								} else
									System.out.println("����ʧ�ܣ�������ѡ�������");
							}
						}

						else if (select3 == 2)// ���߻���Ƹ���
						{
							System.out.println("��������Ҫ���µĻȫ����");
							s = in.next();
							aDto.setAname(s);
							System.out
									.println("------------------------------------------------------------�������µļ�¼Ϊ-----------------------------------------------------");
							if (a.FindActivityByaname(s) == false)// �����¼������FindByPid���治����������������������Ҫɾ���ļ�¼
								System.out.println("������µ�aname=" + s
										+ "�ļ�¼�����ڣ�������ѡ�������");
							else {
								System.out
										.println("*****************���»��*****************");
								System.out.println("��������º�Ļ���ƣ�");
								s2 = in.next();
								System.out.println("���µĻ����Ϊ��" + s2);

								System.out.println("��������º�Ļ����Ժ�������ţ�У������");
								while ((s3 = in.next()) != null) {
									if (s3.equals("����") || s3.equals("Ժ��")
											|| s3.equals("У��"))
										break;
									else
										System.out
												.println("����Ļ�����ʽ�������������루��ʽΪ��Ժ�������ţ�У������");

								}
								System.out.println("���µĻ����Ϊ��" + s3);

								System.out.println("��������º�Ļ�ص㣺");
								s4 = in.next();
								System.out.println("���µĻ�ص�Ϊ��" + s4);

								System.out.println("��������º�Ļ��ʼ�ͽ���ʱ�䣺");
								s5 = in.next();
								System.out.println("���µĻ��ʼ����ʱ��Ϊ��" + s5);

								aDto.setAname(s2);
								aDto.setLevel(s3);
								aDto.setPlace(s4);
								aDto.setDuration(s5);
								if (a.UpdateActivityByaid(aDto) == true) {
									System.out
											.println("---------------------------------------------------------------���³ɹ�--------------------------------------------------------");
									a.FindAllActivity();
									;// ������º�Ļ��
									a.FindAll(3);
								} else
									System.out.println("����ʧ�ܣ�������ѡ�������");
							}
						}

						else if (select3 == 3)
							break;// ���ض����˵�
						else if (select3 == 0)
							break;// �˳�ϵͳ
						
						break;
						// ����˱����
					case 2:
						System.out
								.println("\n***********�����˵���������˱�Ŀ¼***********");
						System.out
								.println("1.ͨ�������pid����\n2.ͨ����������ָ���\n3.���ض������²˵�\n0.�˳�ϵͳ");
						System.out.println("����ͨ��ʲô�����£�");
						System.out
								.println("*****************************************");
						select3 = in.nextInt();
						// ͨ��pid����
						if (select3 == 1) {
							System.out.println("��������Ҫ���µ������pid����ʽΪp01��p02�ȣ���");
							s = in.next();
							eDto.setPid(s);
							System.out
									.println("------------------------------------------------------------�������µļ�¼Ϊ-----------------------------------------------------");
							if (e.FindExaminePBypid(s) == false)// �����¼������FindByPid���治����������������������Ҫɾ���ļ�¼
								System.out.println("������µ�pid=" + s
										+ "�ļ�¼�����ڣ�������ѡ�������");
							else {
								System.out
										.println("****************��������˱�*****************");
								System.out.println("��������º����������֣�");
								s2 = in.next();
								System.out.println("���µ����������Ϊ��" + s2);

								System.out.println("��������º������˵绰���룺");
								s3 = in.next();
								System.out.println("���µ�����˵绰����Ϊ��" + s3);

								eDto.setPname(s2);
								eDto.setPhonenumber(s3);
								if (e.UpdateExaminePBypid(eDto) == true) {
									System.out.println("---------------------------------------------------------------���³ɹ�--------------------------------------------------------");
									e.FindAllExamineP();// ���ɾ����Ļ��
									a.FindAll(3);
								} else
									System.out.println("����ʧ�ܣ�������ѡ�������");
							}
						}

						else if (select3 == 2)// ������������ָ���
						{
							System.out.println("��������Ҫ���µ���������֣�");
							s = in.next();
							System.out.println("------------------------------------------------------------�������µļ�¼Ϊ-----------------------------------------------------");
							if (e.FindExaminePBypname(s) == false)// �����¼������FindByPid���治����������������������Ҫɾ���ļ�¼
								System.out.println("������µ�pname="+s+ "�ļ�¼�����ڣ�������ѡ�������");
							else {
								
								System.out.println("****************��������˱�*****************");
								System.out.println("��������º����������֣�");
								s2 = in.next();
								System.out.println("���µ����������Ϊ��" + s2);

								System.out.println("��������º������˵绰���룺");
								s3 = in.next();
								System.out.println("���µ�����˵绰����Ϊ��" + s3);

								eDto.setPid(e.FindExaminePPidBypname(s));//��ͨ��pname����pid����ͨ��pid����
								eDto.setPname(s2);
								eDto.setPhonenumber(s3);

								if (e.UpdateExaminePBypid(eDto) == true) {//����pnameҪ�����£����Բ�����pname����ѯ�����µķ���
									System.out.println("---------------------------------------------------------------���³ɹ�--------------------------------------------------------");
									e.FindAllExamineP();// ���ɾ����Ļ��
									a.FindAll(3);
								} else
									System.out.println("����ʧ�ܣ�������ѡ�������");
							}
						}

						else if (select3 == 3)
							break;// ���ض����˵�
						else if (select3 == 0)
							break;// �˳�ϵͳ
						
						break;
						// ���»��������
					case 3:
						System.out
								.println("***************���»��������***************");
						System.out.println("��������Ҫ���µĻaid����ʽΪa01��a02�ȣ���");
						s = in.next();
						cDto.setAid(s);
						System.out
								.println("------------------------------------------------------------�������µļ�¼Ϊ-----------------------------------------------------");
						if (c.FindConditionByaid(s) == false)// �����¼������FindConditionByaid(s)���治����������������������Ҫɾ���ļ�¼
							System.out.println("������µ�aid=" + s
									+ "�ļ�¼�����ڣ�������ѡ�������");
						else {

							System.out
									.println("��������Ҫ���µĻ����������ʽΪ����У�δͨ������ͨ������");
							while ((s2 = in.next()) != null) {
								if (s2.equals("�����") || s2.equals("δͨ��")
										|| s2.equals("��ͨ��"))
									break;
								else
									System.out
											.println("��ӵ�����˼����ʽ�������������루��ʽΪ����У�δͨ������ͨ������");

							}
							System.out.println("���µĻ������Ϊ��" + s2);
							cDto.setCon(s2);

							if (s2.equals("δͨ��")) {// �������δͨ������Ҫ����������
								System.out.println("������δͨ����ԭ��");
								s3 = in.next();
								System.out.println("���µĻδͨ��ԭ��Ϊ��" + s3);
								cDto.setNreason(s3);
							} else {
								cDto.setNreason("��");
							}

							if (c.UpdateConByaid(cDto) == true) {
								System.out
										.println("---------------------------------------------------------------���³ɹ�--------------------------------------------------------");
								c.FindAllCondition();
								a.FindAll(3);
							} else
								System.out.println("����ʧ�ܣ�������ѡ�������");
						}

						break;

					case 4:// ����һ���˵�
						break;

					case 0:// �˳�ϵͳ
						break;

					default:
						System.out.println("������Ĳ��������������������룡");
						break;

					}// switch(select2����)

				}// while(select2)ĩβ

				break;// �ļ��˵�case4����

			// --------------------------------------------------------------һ���˵��˳�ϵͳ-----------------------------------------------------
			case 0:
				System.out.println("��л����ʹ�ã�");
				break;

			// һ���˵�ĩβ
			default:
				System.out.println("������Ĳ��������������������룡");
				break;

			}
			if (select2 == 0 || select3 == 0) {// �����˵��������˵�ѡ���˳�ϵͳ
				System.out.println("��л����ʹ�ã�");
				break;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("----------��ӭʹ�ô�ѧ�����ϵͳ----------");
		Event(1);
	}
}
*/