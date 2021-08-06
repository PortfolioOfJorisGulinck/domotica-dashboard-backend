CREATE TABLE users (
                       id INTEGER PRIMARY KEY,
                       user_name varchar(255) NOT NULL,
                       password varchar(255) NOT NULL,
                       active boolean NOT NULL,
                       roles varchar(255) NOT NULL
);

CREATE TABLE floors (
                        floor_id INTEGER PRIMARY KEY,
                        image VARCHAR(255),
                        name VARCHAR(255) NOT NULL
);

CREATE TABLE rooms (
                       room_id INTEGER PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       description VARCHAR (255),
                       service_id INTEGER,
                       position_id INTEGER,
                       dimension_id INTEGER,
                       floor_id INTEGER
);

CREATE TABLE dimensions (
                            dimension_id INTEGER PRIMARY KEY,
                            width INTEGER,
                            height INTEGER,
                            room_id INTEGER
);

CREATE TABLE positions (
                           position_id INTEGER PRIMARY KEY,
                           top INTEGER,
                           lef INTEGER,
                           room_id INTEGER
);

CREATE TABLE schemes (
                         schema_id INTEGER PRIMARY KEY,
                         start INTEGER,
                         end INTEGER,
                         room_id INTEGER,
                         service_id INTEGER
);

CREATE TABLE automationServices (
                          service_id INTEGER PRIMARY KEY,
                          service_type VARCHAR(255),
                          value VARCHAR(255),
                          room_id INTEGER,
                          schema_id INTEGER
);

ALTER TABLE rooms ADD CONSTRAINT fk_service_id_ro FOREIGN KEY (service_id) REFERENCES automationServices(service_id) ON DELETE CASCADE;
ALTER TABLE rooms ADD CONSTRAINT fk_position_id_ro FOREIGN KEY (position_id) REFERENCES positions(position_id) ON DELETE CASCADE;
ALTER TABLE rooms ADD CONSTRAINT fk_dimension_id_ro FOREIGN KEY (dimension_id) REFERENCES dimensions(dimension_id) ON DELETE CASCADE;
ALTER TABLE rooms ADD CONSTRAINT fk_floor_id_ro FOREIGN KEY (floor_id) REFERENCES floors(floor_id) ON DELETE CASCADE;
ALTER TABLE dimensions ADD CONSTRAINT fk_room_id_dim FOREIGN KEY (room_id) REFERENCES rooms(room_id) ON DELETE CASCADE;
ALTER TABLE positions ADD CONSTRAINT fk_room_id_pod FOREIGN KEY (room_id) REFERENCES rooms(room_id) ON DELETE CASCADE;
ALTER TABLE schemes ADD CONSTRAINT fk_room_id_sch FOREIGN KEY (room_id) REFERENCES rooms(room_id) ON DELETE CASCADE;
ALTER TABLE schemes ADD CONSTRAINT fk_service_id_sch FOREIGN KEY (service_id) REFERENCES automationServices(service_id) ON DELETE CASCADE;
ALTER TABLE automationServices ADD CONSTRAINT fk_room_id_serv FOREIGN KEY (room_id) REFERENCES rooms(room_id) ON DELETE CASCADE;
ALTER TABLE automationServices ADD CONSTRAINT fk_schema_id_serv FOREIGN KEY (schema_id) REFERENCES schemes(schema_id) ON DELETE CASCADE;

INSERT INTO users VALUES (1, 'user', 'user', true, 'USER');

INSERT INTO floors VALUES (1, 'Kelder', '/images/kelder.jpg');
INSERT INTO floors VALUES (2, 'Gelijkvloers', '/images/gelijkvloers.jpg');
INSERT INTO floors VALUES (3, '1e verdiep', '/images/eerste-verdiep.jpg');
INSERT INTO floors VALUES (4, 'Zolder', '/images/zolder.jpg');



