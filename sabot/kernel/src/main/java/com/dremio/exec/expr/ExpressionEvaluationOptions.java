/*
 * Copyright (C) 2017-2018 Dremio Corporation
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
package com.dremio.exec.expr;

import com.dremio.common.expression.SupportedEngines;
import com.dremio.exec.ExecConstants;
import com.dremio.options.OptionManager;

public class ExpressionEvaluationOptions {
  private final OptionManager options;
  private SupportedEngines.CodeGenOption codeGenOption = SupportedEngines.CodeGenOption.DEFAULT;

  public ExpressionEvaluationOptions(OptionManager options) {
    this.options = options;
  }

  public void setCodeGenOption(String codeGenOption) {
    // convert the string value to the enum value
    this.codeGenOption = SupportedEngines.CodeGenOption.getCodeGenOption(codeGenOption);
  }

  public SupportedEngines.CodeGenOption getCodeGenOption() {
    return codeGenOption;
  }

  public boolean isSplitEnabled() { return options.getOption(ExecConstants.SPLIT_ENABLED); }
}
