CREATE TABLE IF NOT EXISTS ingredientes(
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(200),
    etiquetas BIGINT,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS recetas(
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(200),
    instrucciones TEXT,
    ingredientes BIGINT,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS etiquetas(
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE ingredientes ADD UNIQUE (nombre);
ALTER TABLE recetas ADD UNIQUE (nombre);
ALTER TABLE etiquetas ADD UNIQUE (nombre);

CREATE TABLE IF NOT EXISTS map_ingrediente_etiqueta(
    ingrediente_id BIGINT NOT NULL,
    etiqueta_id BIGINT NOT NULL,
    PRIMARY KEY (ingrediente_id, etiqueta_id)
);

CREATE TABLE IF NOT EXISTS map_receta_etiqueta(
    receta_id BIGINT NOT NULL,
    etiqueta_id BIGINT NOT NULL,
    PRIMARY KEY (receta_id, etiqueta_id)
);

CREATE TABLE IF NOT EXISTS map_ingredientes_receta(
    receta_id BIGINT NOT NULL,
    ingrediente_id BIGINT NOT NULL,
    PRIMARY KEY (receta_id, ingrediente_id)
);

ALTER TABLE map_ingrediente_etiqueta
ADD CONSTRAINT fk_ingrediente_etiqueta_ingrediente_id
FOREIGN KEY (ingrediente_id) REFERENCES ingredientes(id);

ALTER TABLE map_ingrediente_etiqueta
ADD CONSTRAINT fk_ingrediente_etiqueta_etiqueta_id
FOREIGN KEY (etiqueta_id) REFERENCES etiquetas(id);

ALTER TABLE map_receta_etiqueta
ADD CONSTRAINT fk_receta_etiqueta_id_receta_id
FOREIGN KEY (receta_id) REFERENCES recetas(id);

ALTER TABLE map_receta_etiqueta
ADD CONSTRAINT fk_receta_etiqueta_id_etiqueta_id
FOREIGN KEY (etiqueta_id) REFERENCES etiquetas(id);

ALTER TABLE map_ingredientes_receta
ADD CONSTRAINT fk_ingredientes_receta_ingrediente_id
FOREIGN KEY (ingrediente_id) REFERENCES ingredientes(id);

ALTER TABLE map_ingredientes_receta
ADD CONSTRAINT fk_ingredientes_receta_receta_id
FOREIGN KEY (receta_id) REFERENCES recetas(id);
