alter table entrega add destinatario_cep varchar(9) not null;
alter table entrega add destinatario_localidade varchar(60) not null;
alter table entrega add destinatario_uf varchar(2) not null;
alter table entrega add destinatario_ibge varchar(7) not null;
alter table entrega add destinatario_gia varchar(4) not null;
alter table entrega add destinatario_ddd varchar(2) not null;
alter table entrega add destinatario_siafi varchar(4) not null;