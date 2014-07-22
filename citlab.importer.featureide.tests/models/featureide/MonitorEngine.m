MonitorEngine : MonitorEngineperformance MonitorFuelConsumption :: _MonitorEngine ;

MonitorEngineperformance : Monitortemperatures MonitorRPM Monitorexhaustlevelsandtemperature :: _MonitorEngineperformance ;

Monitortemperatures : [coolant] oil engine transmission :: _Monitortemperatures ;

MonitorFuelConsumption : Measures Methods temperature* :: _MonitorFuelConsumption ;

Measures : a1perkm
	| gallonpermile ;

Methods : Basedondistance
	| Basedontypeofdriving
	| Basedondriving ;

temperature : F1
	| F2 ;

