SmartHome : HeatingManagement WindowsManagement LightManagement GUI PresenceSimulator* FireControl [IrrigationSprinklers] Alarm+ Security :: _SmartHome ;

HeatingManagement : ManualHeating [SmartHeating] :: _HeatingManagement ;

WindowsManagement : ManualWindows [ElectronicWindows] :: _WindowsManagement ;

LightManagement : ManualLight [SmartLight] [Pre_definedValues] :: _LightManagement ;

GUI : TouchScreen [Internet] :: _GUI ;

PresenceSimulator : LightSimulation
	| BlindSimulation
	| MusicSimulation ;

FireControl : FirstAidGroup+ :: _FireControl ;

FirstAidGroup : FireDepartment
	| OtherGroup
	| FireSprinklers ;

IrrigationSprinklers : SimpleControl [SmartSprinklers] :: _IrrigationSprinklers ;

Alarm : Siren
	| Bell
	| Lights ;

Security : AuthenticationDevice+ IntrusionDetectionDevice* :: _Security ;

AuthenticationDevice : Keypad
	| RetinaScanner
	| FingerPrintReader ;

IntrusionDetectionDevice : GlassbreakSensors
	| Cameras ;

