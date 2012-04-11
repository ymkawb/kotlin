/*
 * Copyright 2010-2012 JetBrains s.r.o.
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

package org.jetbrains.jet.lang.diagnostics;

import com.intellij.openapi.util.TextRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jet.lang.psi.JetArrayAccessExpression;
import org.jetbrains.jet.lang.psi.JetReferenceExpression;

import java.util.Collections;
import java.util.List;

import static org.jetbrains.jet.lang.diagnostics.Severity.ERROR;

/**
 * @author abreslav
 */
public class UnresolvedReferenceDiagnostic extends AbstractDiagnostic<JetReferenceExpression> {
    @NotNull
    @Override
    public UnresolvedReferenceDiagnosticFactory getFactory() {
        return (UnresolvedReferenceDiagnosticFactory)super.getFactory();
    }

    public UnresolvedReferenceDiagnostic(@NotNull JetReferenceExpression referenceExpression,
            @NotNull UnresolvedReferenceDiagnosticFactory factory) {
        super(referenceExpression, factory, ERROR);
    }

    @NotNull
    @Override
    public String getMessage() {
        return getFactory().getMessage() + ": " + getPsiElement().getText();
    }

    @NotNull
    @Override
    public List<TextRange> getTextRanges() {
        JetReferenceExpression element = getPsiElement();
        if (element instanceof JetArrayAccessExpression) {
            return ((JetArrayAccessExpression) element).getBracketRanges();
        }
        return Collections.singletonList(element.getTextRange());
    }
}
