/*
 * Copyright (C) 2009 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.sites.liberation.export;

import com.google.inject.AbstractModule;
import com.google.sites.liberation.util.CompositeProgressListener;
import com.google.sites.liberation.util.LoggingProgressListener;
import com.google.sites.liberation.util.ProgressListener;
import com.google.sites.liberation.util.StdOutProgressListener;

import java.io.File;
import java.io.IOException;

/**
 * GUICE module defining default bindings.
 */
public class SiteExporterModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(EntryStoreFactory.class).to(InMemoryEntryStoreFactory.class);
    bind(AppendableFactory.class).to(BufferedWriterFactory.class);
    bind(ProgressListener.class).toInstance(
        new CompositeProgressListener(
            new StdOutProgressListener(), new LoggingProgressListener()));
  }
}
