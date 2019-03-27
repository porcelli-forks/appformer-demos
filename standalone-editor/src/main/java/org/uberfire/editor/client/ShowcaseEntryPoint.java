package org.uberfire.editor.client;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.enterprise.client.jaxrs.api.RestClient;
import org.jboss.errai.ioc.client.api.EntryPoint;
import org.uberfire.client.mvp.ActivityManager;
import org.uberfire.editor.client.screens.EditorPresenter;

import com.google.gwt.animation.client.Animation;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

@EntryPoint
public class ShowcaseEntryPoint {

    @PostConstruct
    public void startApp() {
    }
}