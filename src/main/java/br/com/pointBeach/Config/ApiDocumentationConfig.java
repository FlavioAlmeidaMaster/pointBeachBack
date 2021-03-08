package br.com.pointBeach.Config;

import io.swagger.annotations.Contact;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(
        info = @Info(
                title = "Point Beach API",
                description = "Sistema de controle de vendas",
                version = "0.0.1",
                contact = @Contact(
                        name = "Flavio Almeida",
                        email = "flavio.almeida53@gmail.com",
                        url = "https://github.com/flavioAlmeida"
                ),
                license = @License(
                        name = "License",
                        url = "http://www.license.url"
                )
        ),
        consumes = { "application/json", "application/xml" },
        produces = { "application/json", "application/xml" },
        schemes = { SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS },
        externalDocs = @ExternalDocs(value = "Flavio", url = "https://github.com/flavioalmeida")
)
public class ApiDocumentationConfig {

}
