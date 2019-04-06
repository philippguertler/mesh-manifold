package com.gentics.mesh.manifold.schemas;

import com.gentics.mesh.core.rest.schema.SchemaListResponse;
import manifold.api.gen.SrcClass;
import manifold.api.gen.SrcMethod;
import manifold.api.gen.SrcRawStatement;
import manifold.api.gen.SrcStatementBlock;

import java.lang.reflect.Modifier;

public class SchemaClassesGen {
    private final SchemaListResponse schemas;
    private final String fqn;

    public SchemaClassesGen(SchemaListResponse schemas, String fqn) {
        this.schemas = schemas;
        this.fqn = fqn;
    }

    public SrcClass make() {

        return new SrcClass(fqn, SrcClass.Kind.Class)
            .addMethod(new SrcMethod()
                .modifiers(Modifier.PUBLIC)
                .name("sayHello")
                .body(new SrcStatementBlock()
                    .addStatement(new SrcRawStatement()
                    .rawText("System.out.println(\"Hello!\");")))
                );
    }
}
