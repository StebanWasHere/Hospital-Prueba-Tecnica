-- Crear tabla 'especialidad'
CREATE TABLE especialidad (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo_cita VARCHAR(10) NOT NULL
);

-- Crear tabla 'identificacion_usuario'
CREATE TABLE identificacion_usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    identificacion VARCHAR(10) NOT NULL
);

-- Crear tabla 'usuario'
CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    especialidad_id BIGINT NOT NULL,
    identificacion_usuario_id BIGINT NOT NULL,
    tipo_usuario VARCHAR(255) NOT NULL,
    CONSTRAINT fk_especialidad FOREIGN KEY (especialidad_id) REFERENCES especialidad(id),
    CONSTRAINT fk_identificacion_usuario FOREIGN KEY (identificacion_usuario_id) REFERENCES identificacion_usuario(id)
);

-- Crear tabla 'cita_medica'
CREATE TABLE cita_medica (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha_cita TIMESTAMP NOT NULL,
    usuario_id BIGINT NOT NULL,
    CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);
