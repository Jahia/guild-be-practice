package org.jahia.modules.guild.graphql.sendmail;

import graphql.annotations.annotationTypes.*;
import org.jahia.modules.graphql.provider.dxm.DXGraphQLProvider;
import org.jahia.modules.guild.graphql.models.GraphQLMailStub;
import org.jahia.services.mail.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@GraphQLTypeExtension(DXGraphQLProvider.Query.class)
@GraphQLDescription("a GraphQL extension of mail service")
public class QueryExtension {

    private static Logger logger = LoggerFactory.getLogger(QueryExtension.class);

    private MailService mailService;

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

        String textBody = "test email is sent for guild backend practice - sendmail API";

        //TODO expose DX core mail service
        MailService mailService = MailService.getInstance();
        if (mailService==null) {
            return new GraphQLMailStub("ERROR", false, textBody);
        }
        mailService.sendMessage("cyip@jahia.com", receiver, null, null, subject, textBody, null);

        return new GraphQLMailStub("OK", mailService.isEnabled(), textBody);

    }

}