package org.jahia.modules.guild.graphql.sendmail;

import graphql.annotations.annotationTypes.*;
import org.jahia.modules.graphql.provider.dxm.DXGraphQLProvider;
import org.jahia.modules.guild.graphql.models.GraphQLMailStub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@GraphQLTypeExtension(DXGraphQLProvider.Query.class)
@GraphQLDescription("a GraphQL extension of mail service")
public class QueryExtension {

    private static Logger logger = LoggerFactory.getLogger(QueryExtension.class);

    @GraphQLField
    public static GraphQLMailStub sendmail(@GraphQLNonNull
                                           @GraphQLName("receiver")
                                           @GraphQLDescription("mail receiver")
                                                   String receiver,
                                           @GraphQLNonNull
                                           @GraphQLName("subject")
                                           @GraphQLDescription("mail subject")
                                                   String subject) throws Exception {

        logger.debug("Expose mail sending service, receiver: {}, subject {} ", receiver, subject);

        //TODO expose DX core mail service

        return new GraphQLMailStub();
    }

}