package ru.kpfu.itis.gnt.okno.dal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.gnt.okno.dal.models.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

    Page<Attachment> findAllByTaskId(Pageable pageable, Long taskId);

}

/**
 spring.application.name=okno

 server.tomcat.accesslog.enabled=true

 spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
 spring.jpa.hibernate.ddl-auto=update

 spring.datasource.url=jdbc:postgresql://21KQudLwy3SGZHDhKGSUIcz18MJwmKbF@dpg-cohtdh779t8c7387svp0-a.oregon-postgres.render.com:5432/okno
 spring.datasource.username=okno_user
 spring.datasource.password=21KQudLwy3SGZHDhKGSUIcz18MJwmKbF
 spring.datasource.driver-class-name=org.postgresql.Driver

 spring.jpa.hibernate.show-sql=true

 spring.jpa.open-in-view=false

 springdoc.swagger-ui.path=/docs

 server.port=8080
 */
