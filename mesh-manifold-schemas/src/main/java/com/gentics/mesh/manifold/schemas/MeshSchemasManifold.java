package com.gentics.mesh.manifold.schemas;

import manifold.api.fs.IFile;
import manifold.api.host.IModule;
import manifold.api.type.JavaTypeManifold;

import javax.tools.DiagnosticListener;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;

public class MeshSchemasManifold extends JavaTypeManifold<Model> {

    @Override
    public void init(IModule module) {
        init(module, (host, fqn) -> new Model( getModule().getHost(), host, fqn ));
    }

    @Override
    public boolean isInnerType(String topLevelFqn, String relativeInner) {
        return false;
    }

    @Override
    public boolean handlesFileExtension(String fileExtension) {
        return "json".equals(fileExtension);
    }

    @Override
    public boolean handlesFile(IFile file) {
        return true;
    }

    @Override
    public String getTypeNameForFile(String defaultFqn, IFile file) {
        return "meshmanifold.Schemas";
    }

    @Override
    protected String contribute(JavaFileManager.Location location, String topLevelFqn, String existing, Model model, DiagnosticListener<JavaFileObject> errorHandler) {
        return new SchemaClassesGen(model.getSchemas(), topLevelFqn).make()
            .render().toString();
    }
}
