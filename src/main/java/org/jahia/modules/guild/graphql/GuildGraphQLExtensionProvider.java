package org.jahia.modules.guild.graphql;

import org.jahia.modules.graphql.provider.dxm.DXGraphQLExtensionsProvider;
import org.jahia.modules.guild.graphql.sendmail.QueryExtension;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component(service = DXGraphQLExtensionsProvider.class, immediate = true)
public class GuildGraphQLExtensionProvider implements DXGraphQLExtensionsProvider {

    @Override
    public Collection<Class<?>> getExtensions() {
        List<Class<?>> extensions = new ArrayList<>();
        extensions.add(QueryExtension.class);
        return extensions;
    }

}