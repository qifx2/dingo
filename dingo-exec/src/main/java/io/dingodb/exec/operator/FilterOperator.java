/*
 * Copyright 2021 DataCanvas
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

package io.dingodb.exec.operator;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.dingodb.common.type.DingoType;
import io.dingodb.exec.expr.SqlExpr;
import io.dingodb.exec.fin.Fin;

@JsonTypeName("filter")
@JsonPropertyOrder({"filter", "schema", "output"})
public final class FilterOperator extends SoleOutOperator {
    @JsonProperty("filter")
    private final SqlExpr filter;
    @JsonProperty("schema")
    private final DingoType schema;

    @JsonCreator
    public FilterOperator(
        @JsonProperty("filter") SqlExpr filter,
        @JsonProperty("schema") DingoType schema
    ) {
        super();
        this.filter = filter;
        this.schema = schema;
    }

    @Override
    public void init() {
        super.init();
        filter.compileIn(schema, getParasType());
    }

    @Override
    public synchronized boolean push(int pin, Object[] tuple) {
        // The eval result may be `null`
        Boolean v = (Boolean) filter.eval(tuple);
        if (v != null && v) {
            return output.push(tuple);
        }
        return true;
    }

    @Override
    public synchronized void fin(int pin, Fin fin) {
        output.fin(fin);
    }

    @Override
    public void setParas(Object[] paras) {
        super.setParas(paras);
        filter.setParas(paras);
    }
}
