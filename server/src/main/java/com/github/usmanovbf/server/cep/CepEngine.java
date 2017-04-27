package com.github.usmanovbf.server.cep;

import com.github.usmanovbf.server.api.EventDto;
import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderConfiguration;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CepEngine {
    private Logger logger = LoggerFactory.getLogger( CepEngine.class );

    private StatefulKnowledgeSession session;

    public void doWork( EventDto eventDto ) {
        initKieEnvironment();
        logger.info( "KieEnvironment initialed" );

        session.insert( eventDto );
        logger.info( "Even inserted in kie:" + eventDto.toString() );

        session.fireAllRules();
        logger.info( "AllRules are fired" );
    }

    private void initKieEnvironment() {
        KnowledgeBuilderConfiguration conf = KnowledgeBuilderFactory.newKnowledgeBuilderConfiguration();
        KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder( conf );
        logger.info( "KnowledgeBuilder created" );

        knowledgeBuilder.add( ResourceFactory.newClassPathResource( "rules/temperature.drl" ), ResourceType.DRL );
        logger.info( ".drl file uploaded" );

        KnowledgeBase knowledgeBase = knowledgeBuilder.newKnowledgeBase();
        logger.info( "knowledgeBase created" );

        session = knowledgeBase.newStatefulKnowledgeSession();
        logger.info( "session created" );
    }

}
