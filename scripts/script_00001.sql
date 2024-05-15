insert into geoged.tenant_id values(nextval('seq_tenant_id'),'GEOGED','08741967000136', 'GEOGED',CURRENT_TIMESTAMP,0);
insert into geoged.usuario values(nextval('seq_usuario'),2,'MARCUS CESAR','12345', 'm@gmail.com',CURRENT_TIMESTAMP);
insert into geoged.equipe values(nextval('seq_equipe'),2, 'EXTERNA', CURRENT_TIMESTAMP);
insert into geoged.colaborador values(nextval('seq_colaborador'),2, 'MARCUS CESAR','73074764600');
insert into geoged.equipecolaborador values(nextval('seq_equipecolaborador'),2,1,1);
insert into geoged.acaotipo values(nextval('seq_acaotipo'),2,'VOO', 1);
insert into geoged.equipamento values(nextval('seq_equipamento'), 2,'DRONE','DRONE MINI DLI', '123456',1);
insert into geoged.equipamentogrupo values(nextval('seq_equipamentogrupo'), 2,'DRONES',CURRENT_TIMESTAMP);
