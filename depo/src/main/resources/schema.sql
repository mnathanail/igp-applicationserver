CREATE TABLE IF NOT EXISTS foreas
(
    foreasid      integer not null
        constraint foreas_pkey
            primary key,
    active        boolean not null,
    address       varchar(255),
    afm           varchar(9),
    contactmember varchar(255),
    title         varchar(255),
    doy           varchar(255),
    email         varchar(255),
    fax           varchar(255),
    gemh          varchar(255),
    name          varchar(30),
    password      varchar(30),
    phone         varchar(255),
    roles         varchar(255),
    surname       varchar(30),
    username      varchar(30)
);

alter table foreas
    owner to postgres;
    
CREATE TABLE IF NOT EXISTS aitisi
(
    id             serial not null
        constraint documents_pk
            primary key,
    docname1       text default 255,
    docname2       text default 255,
    docname3       text default 255,
    docname4       text default 255,
    docname5       text default 255,
    docname6       text default 255,
    docname7       text default 255,
    docname8       text default 255,
    docname9       text default 255,
    docname10      text default 255,
    docname11      text default 255,
    docname12      text default 255,
    docname13      text default 255,
    docname14      text default 255,
    foreas_id      integer
        constraint aitisi_foreas_id_fk
            references foreas
);

alter table aitisi
    owner to postgres;
    
