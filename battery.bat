echo off
"C:\Program Files\Java\jre1.8.0_31\bin\java.exe" -Dfile.encoding=Cp1252 -classpath C:\Development\Workspaces\Workspace_BatteryTest\YounicosTask\bin;C:\Development\Workspaces\Workspace_BatteryTest\YounicosTask\lib;C:\Development\Workspaces\Workspace_BatteryTest\YounicosTask\lib\log4j-1.2.17.jar com.younicos.task.BatteryProfileValidator %*
echo on