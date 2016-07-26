@ECHO OFF

:begin


  @set /p password=请输入root用户密码:
  @set /p port=请输入mysql服务端口: 
  echo ###################%date%#####%time%#################################>update.log
  mysql -u root -P%port% -p%password% --comment <meeting.sql --default-character-set=utf8 2> update_tmp.log
  @echo MySql数据库部署完成（meeting）(meeting.sql) >> update_tmp.log
  type update_tmp.log
  type update_tmp.log >> update.log
  del update_tmp.log


  @echo MySql数据库部署完成

  @echo #########################################################
  @echo MySql数据库配置完成,请查看日志文件update.log,并关注是否有ERROR字样。
  pause
:end
