package org.uberfire.editor.server.producers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.jboss.errai.security.shared.api.identity.User;
import org.jboss.errai.security.shared.api.identity.UserImpl;
import org.uberfire.commons.services.cdi.Startup;
import org.uberfire.commons.services.cdi.StartupType;

@Startup(value = StartupType.BOOTSTRAP)
@ApplicationScoped
public class ApplicationScopedProducer {

    @Produces
    public User user() {
        return new UserImpl("admin");
    }
}