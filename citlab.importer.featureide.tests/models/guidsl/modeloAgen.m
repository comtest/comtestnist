ModeloAgen : Agendamento [CadastrodeHorarios] [CadastrodeSalas] [CadastrodeEquipamentos] [CadastrodeAdministradores] Relatorios* :: _ModeloAgen ;

Agendamento : [ImpressaodeFolhadeRosto] [Reagendamento] Notificacao* Regras Visualizacao TipodeUso* :: _Agendamento ;

Notificacao : Email
	| Celular ;

Regras : PorAdm
	| PorUsuario ;

TipodeUso : Reuniao
	| Palestra
	| Treinamento
	| Videoconferencia ;

CadastrodeHorarios : [BloqueiodeHorarios] :: _CadastrodeHorarios ;

CadastrodeSalas : TipodeSala+ :: _CadastrodeSalas ;

TipodeSala : _r_3_25_26_27
	| Aula
	| Auditorio
	| Laboratorio ;

Relatorios : OcupacaoDiaria
	| OcupacaoSemanal ;

%%

CadastrodeSalas or not CadastrodeEquipamentos ;
CadastrodeSalas or not TipodeUso ;

