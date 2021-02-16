;******************************************************************************************************************************************
; [Setup]: Es la parte en donde se configura la aplicaci�n.
;******************************************************************************************************************************************
[Setup]
AppName=BabaYagaStudio
AppVerName=SistemaBabaYaga
DefaultGroupName=SistemaBabaYaga
AppPublisher=BabaYagaStudio
AppVersion=1.0
AllowNoIcons=false
AppCopyright=
PrivilegesRequired=admin

; Este es el nombre del archivo exe que se va a generar
OutputBaseFilename=BabaYagaStudioSetup

; Este es el nombre de la carpeta en la cual se guardar�n los archivos para el programa
; (Por lo general es el mismo nombre de la aplicaci�n)
DefaultDirName={pf}\BabaYagaStudio

;******************************************************************************************************************************************


;******************************************************************************************************************************************
; [Languages] y [Tasks]: No tocar o modificar las siguientes l�neas
;******************************************************************************************************************************************
; [Languages] = Es el lenguaje por defecto
; [Tasks]     = Es la indicaci�n para crear los �conos necesarios para iniciar el programa y para desinstalarlo
[Languages]
Name: "spanish"; MessagesFile: "compiler:Languages\Spanish.isl"

[Tasks]
Name: desktopicon; Description: Create a &desktop icon; GroupDescription: Additional icons:

;******************************************************************************************************************************************


;******************************************************************************************************************************************
; [Files]: Son los archivos que utilizaremos para crear el instalador
;******************************************************************************************************************************************
[Files]

; Nota: Los par�metros: Tienen que ir tal y como aparecen ac�, solo cambiar las rutas C:\ en donde se encuentran los archivos
;       Otra cosa: {sys} = carpeta system de windows
;                  {win} = carpeta windows de windows
;                  {cf}  = carpeta archivos comunes de windows
;                  {tmp} = carpeta temporal de windows
;                  {app} = carpeta donde se va a instalar el programa (fue definida arriba en el par�metro: DefaultDirName= )
; -----------------------------------------------------------------------------------------------------------------------------------------
; Aqu� van los archivos de la aplicaci�n: El .exe y otros que ocupe el programa la aplicaci�n
Source: C:\Users\JHL\Documents\JORGE_Personal\Materias\POO\2021-1\Instaladores\requiere\BabaYagaStudio.exe; DestDir: {app}; Flags: ignoreversion
Source: C:\Users\JHL\Documents\JORGE_Personal\Materias\POO\2021-1\Instaladores\requiere\*; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: C:\Users\JHL\Documents\JORGE_Personal\Materias\POO\2021-1\Instaladores\comp\babayaga_db.sql*; DestDir: {tmp}; Flags : ignoreversion deleteafterinstall
;Source: C:\Users\JHL\Documents\JORGE_Personal\Materias\POO\2021-1\Instaladores\requiere\mysql-installer-community-8.0.23.0.msi; DestDir: {tmp}; Flags : deleteafterinstall

;******************************************************************************************************************************************


; Omitir esta linea [INI] - No tocar o modificar la siguiente l�nea
[INI]


;******************************************************************************************************************************************
; [Icons]: Estos son los �conos que el instalador creara en el grupo de programas del sistema de Windows
;******************************************************************************************************************************************
[Icons]

; Nota: Aqu� se incluye: El �cono para abrir el programa
;                        El �cono para desinstalar el programa
;                        El �cono que se ubica en el escritorio
; -----------------------------------------------------------------------------------------------------------------------------------------
; {group} = nombre del grupo de programa que se defini� arriba en el par�metro: DefaultGroupName=
;           (Por lo general es el mismo nombre de la aplicaci�n)
Name: {group}\BabaYagaStudio; Filename: {app}\BabaYagaStudio.exe; WorkingDir: {app}; IconIndex: 0
Name: {group}\Desinstalar BabaYagaStudio; Filename: {uninstallexe}
Name: {userdesktop}\BabaYagaStudio; Filename: {app}\BabaYagaStudio.exe; Tasks: desktopicon; WorkingDir: {app}; IconIndex: 0

;******************************************************************************************************************************************


;******************************************************************************************************************************************
; [Run]: Estos son los programas que se instalar como complementos de nuestra aplicaci�n
;******************************************************************************************************************************************
[Run]

; Nota: Esto se ejecuta al momento de la instalaci�n de nuestro programa

; Instalamos MySQL
; (Aqu� tenemos que poner el nombre de nuestro motor de base de datos que se encuentra en nuestra carpeta complementos)
Filename: {src}\comp\mysql-installer-community-8.0.23.0.msi; Description: MySQL Server; Verb: open; Flags: shellexec waituntilidle runascurrentuser
; Esto nos permite crear la base de datos
; (Aqu� ponemos el nombre de nuestra base de datos y cambiamos nuestra ruta  C:\ si es necesario)
Filename: C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql.exe; Parameters: "-u root -h localhost -e ""create database tattoo_studio_db CHARACTER SET 'utf8' COLLATE utf8_spanish_ci";  WorkingDir: {tmp}; StatusMsg: Creando la Base dedatos; Flags: runhidden

; Cargamos la base de datos
; (Acedemos a nuestra base de datos, cargamos nuestras tablas coon nuestro arcchivo [.sql] y cambiamos nuestra ruta  C:\ si es necesario)
Filename: C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql.exe; Parameters: "-u root -h localhost -e ""use tattoo_studio_db; source babayaga_db.sql;";  WorkingDir: {tmp}; StatusMsg: Cargando la Base de Datos; Flags: runhidden

;******************************************************************************************************************************************


;******************************************************************************************************************************************
; [Messages]: Estos mensajes simplemente son un override ya que vienen en ingl�s
;             (Cambia los valores de las etiquetas para que aparezcan con el nombre de tu aplicaci�n)
;******************************************************************************************************************************************
[Messages]

; Este es el t�tulo que se mostrara al momento de iniciar el cuadro de dialogo de la instalaci�n (Cambia el Nombre_Aplicaci�n por el nombre de tu aplicacion)
WelcomeLabel1=Instalaci�n del Sistema para BabaYaga Studio

; Este es e� titulo que se mostrara debajo del titulo (Cambia el Nombre_Aplicaci�n por el nombre de tu aplicacion)
WelcomeLabel2=Este proceso instalar� BabaYagaStudio.%n%nSe recomienda cerrar todas las aplicaciones abiertas%nantes de continuar.

;******************************************************************************************************************************************