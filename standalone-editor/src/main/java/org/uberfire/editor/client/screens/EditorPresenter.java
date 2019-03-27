/*
 * Copyright 2019 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.uberfire.editor.client.screens;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import elemental2.promise.Promise;
import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.uberfire.client.annotations.WorkbenchClientEditor;
import org.uberfire.client.annotations.WorkbenchPartTitle;
import org.uberfire.client.annotations.WorkbenchPartView;
import org.uberfire.client.mvp.UberElemental;
import org.uberfire.client.promise.Promises;
import org.uberfire.editor.shared.EchoBackend;
import org.uberfire.lifecycle.GetContent;
import org.uberfire.lifecycle.IsDirty;
import org.uberfire.lifecycle.OnOpen;
import org.uberfire.lifecycle.SetContent;

@ApplicationScoped
@WorkbenchClientEditor(identifier = "EditorPresenter")
public class EditorPresenter {

    public interface View extends UberElemental<EditorPresenter> {

        void setContent(String content);

        String getContent();
    }

    @Inject
    private View view;

    @Inject
    Caller<EchoBackend> echoBackendCaller;

    @Inject
    private Promises promises;

    @PostConstruct
    public void init() {
        view.init(this);
    }

    @OnOpen
    public void onOpen() {
    }

    @WorkbenchPartTitle
    public String getTitle() {
        return "Editor";
    }

    @WorkbenchPartView
    public View getView() {
        return view;
    }

    @SetContent
    public void setContent(final String value) {
        echoBackendCaller.call((RemoteCallback<String>) stirng -> view.setContent(stirng)).setContent(value);
    }

    @GetContent
    public Promise getContent() {
        return promises.promisify(echoBackendCaller, s -> {
            return s.getContent(view.getContent());
        });
    }

    @IsDirty
    public boolean isDirty() {
        return false;
    }
}
