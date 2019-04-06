package com.gentics.mesh.manifold.schemas;

import com.gentics.mesh.core.rest.schema.SchemaListResponse;
import com.gentics.mesh.json.JsonUtil;
import manifold.api.fs.IFile;
import manifold.api.host.IManifoldHost;
import manifold.api.type.AbstractSingleFileModel;

import java.util.Set;

public class Model extends AbstractSingleFileModel {
    private SchemaListResponse schemas;

    public Model(IManifoldHost host, String fqn, Set<IFile> files) {
        super(host, fqn, files);
        assignJson();
    }

    @Override
    public void updateFile(IFile file) {
        super.updateFile(file);
        assignJson();
    }

    public SchemaListResponse getSchemas() {
        return schemas;
    }

    private void assignJson() {
        schemas = JsonUtil.readValue(
            getFile().toJavaFile().readText(),
            SchemaListResponse.class
        );
    }
}
