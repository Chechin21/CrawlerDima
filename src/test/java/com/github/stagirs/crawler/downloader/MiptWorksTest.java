/*
 * Copyright 2017 Dmitriy Malakhov.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.stagirs.crawler.downloader;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Dmitriy Malakhov
 */
public class MiptWorksTest extends MiptWorks{
    @Test
    public void test(){
        assertTrue(!isAuthors("Голуб А.П., Селюцкий Ю.Д. О влиянии упругого крепления на колебания двухзвенного аэродинамического маятника (8–13)"));
        assertTrue(startByAuthor("Голуб А.П., Селюцкий Ю.Д. О влиянии упругого крепления на колебания двухзвенного аэродинамического маятника (8–13)"));
    }
}
