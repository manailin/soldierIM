@ECHO OFF

:begin


  @set /p password=������root�û�����:
  @set /p port=������mysql����˿�: 
  echo ###################%date%#####%time%#################################>update.log
  mysql -u root -P%port% -p%password% --comment <meeting.sql --default-character-set=utf8 2> update_tmp.log
  @echo MySql���ݿⲿ����ɣ�meeting��(meeting.sql) >> update_tmp.log
  type update_tmp.log
  type update_tmp.log >> update.log
  del update_tmp.log


  @echo MySql���ݿⲿ�����

  @echo #########################################################
  @echo MySql���ݿ��������,��鿴��־�ļ�update.log,����ע�Ƿ���ERROR������
  pause
:end
