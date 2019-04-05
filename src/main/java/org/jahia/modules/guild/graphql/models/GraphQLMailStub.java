package org.jahia.modules.guild.graphql.models;

import graphql.annotations.annotationTypes.GraphQLDescription;
import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;

@GraphQLName("MailStub")
@GraphQLDescription("Mail stub for mail sent status")
public class GraphQLMailStub {

    @GraphQLField
    private String status;

    @GraphQLField
    private boolean isMailServiceEnabled;

    @GraphQLField
    private String payload;

    public GraphQLMailStub(){
        //void
    }

    public GraphQLMailStub(String status, boolean mailServiceEnable, String payload){
        this.status = status;
        this.isMailServiceEnabled = mailServiceEnable;
        this.payload = payload;
    }

    public String getStatus() { return this.status; }
    public String getPayload() {
        return this.payload;
    }
    public boolean isMailServiceEnabled() { return this.isMailServiceEnabled; }

}
