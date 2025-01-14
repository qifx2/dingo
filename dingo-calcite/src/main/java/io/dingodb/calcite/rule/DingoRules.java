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

package io.dingodb.calcite.rule;

import com.google.common.collect.ImmutableList;
import org.apache.calcite.plan.RelOptRule;
import org.apache.calcite.rel.rules.CoreRules;

import java.util.List;

public final class DingoRules {
    public static final LogicalDingoValueRule LOGICAL_DINGO_VALUE_RULE
        = LogicalDingoValueRule.DEFAULT_CONFIG.toRule(LogicalDingoValueRule.class);

    // Substitution rules
    public static final DingoValuesReduceRule DINGO_PROJECT_VALUES_MERGE
        = DingoValuesReduceRule.Config.PROJECT.toRule();
    public static final DingoValuesReduceRule DINGO_FILTER_VALUES_MERGE
        = DingoValuesReduceRule.Config.FILTER.toRule();
    public static final DingoUnionValuesRule DINGO_UNION_VALUES_RULE
        = DingoUnionValuesRule.Config.DEFAULT.toRule();
    public static final DingoCollectValuesRule DINGO_COLLECT_VALUES_RULE
        = DingoCollectValuesRule.Config.DEFAULT.toRule();
    public static final DingoJoinValuesRule DINGO_JOIN_VALUES_RULE
        = DingoJoinValuesRule.Config.DEFAULT.toRule();

    public static final DingoAggregateRule DINGO_AGGREGATE_RULE
        = DingoAggregateRule.Config.DEFAULT.toRule();
    public static final DingoAggregate2AggRootRule DINGO_AGGREGATE_SINGLE_RULE
        = DingoAggregate2AggRootRule.Config.DEFAULT.toRule();
    public static final DingoDistributedValuesRule DINGO_DISTRIBUTED_VALUES_RULE
        = DingoDistributedValuesRule.Config.DEFAULT.toRule();
    public static final DingoExchangeRootRule DINGO_EXCHANGE_ROOT_RULE
        = DingoExchangeRootRule.Config.DEFAULT.toRule();
    public static final DingoFilterRule DINGO_FILTER_RULE_DISTRIBUTED
        = DingoFilterRule.DISTRIBUTED.toRule(DingoFilterRule.class);
    public static final DingoFilterRule DINGO_FILTER_RULE_ROOT
        = DingoFilterRule.ROOT.toRule(DingoFilterRule.class);
    public static final DingoFilterScanRule DINGO_FILTER_TABLE_SCAN_RULE
        = DingoFilterScanRule.Config.DEFAULT.toRule();
    public static final DingoGetByKeysRule DINGO_GET_BY_KEYS_RULE
        = DingoGetByKeysRule.Config.DEFAULT.toRule();
    public static final DingoHashJoinRule DINGO_HASH_JOIN_RULE
        = DingoHashJoinRule.Config.DEFAULT.toRule();
    public static final DingoPartModifyRule DINGO_PART_MODIFY_RULE
        = DingoPartModifyRule.Config.DEFAULT.toRule();
    public static final DingoPartCountRule DINGO_PART_COUNT_RULE
        = DingoPartCountRule.Config.DEFAULT.toRule();
    public static final DingoPartitionDeleteRule DINGO_PARTITION_DELETE_RULE
        = DingoPartitionDeleteRule.Config.DEFAULT.toRule();
    public static final DingoPartScanRule DINGO_PART_SCAN_RULE
        = DingoPartScanRule.Config.DEFAULT.toRule();
    public static final DingoProjectRule DINGO_PROJECT_RULE_DISTRIBUTED
        = DingoProjectRule.DISTRIBUTED.toRule(DingoProjectRule.class);
    public static final DingoProjectRule DINGO_PROJECT_RULE_ROOT
        = DingoProjectRule.ROOT.toRule(DingoProjectRule.class);
    public static final DingoProjectScanRule DINGO_PROJECT_SCAN_RULE
        = DingoProjectScanRule.Config.DEFAULT.toRule();
    public static final DingoSortRule DINGO_SORT_RULE
        = DingoSortRule.DEFAULT_CONFIG.toRule(DingoSortRule.class);
    public static final DingoUnionRule DINGO_UNION_RULE
        = DingoUnionRule.DEFAULT_CONFIG.toRule(DingoUnionRule.class);
    public static final DingoValuesRule DINGO_VALUES_RULE_DISTRIBUTED
        = DingoValuesRule.DISTRIBUTED.toRule(DingoValuesRule.class);
    public static final DingoValuesRule DINGO_VALUES_RULE_ROOT
        = DingoValuesRule.ROOT.toRule(DingoValuesRule.class);
    public static final DingoPartRangeRule DINGO_PART_RANGE_RULE
        = DingoPartRangeRule.Config.DEFAULT.toRule();

    private static final List<RelOptRule> rules = ImmutableList.of(
        CoreRules.PROJECT_REMOVE,
        CoreRules.AGGREGATE_REDUCE_FUNCTIONS,
        CoreRules.AGGREGATE_EXPAND_DISTINCT_AGGREGATES,
        CoreRules.AGGREGATE_EXPAND_DISTINCT_AGGREGATES_TO_JOIN,
        CoreRules.JOIN_EXTRACT_FILTER,
        CoreRules.FILTER_INTO_JOIN,
        LOGICAL_DINGO_VALUE_RULE,
        DINGO_FILTER_VALUES_MERGE,
        DINGO_PROJECT_VALUES_MERGE,
        DINGO_UNION_VALUES_RULE,
        DINGO_COLLECT_VALUES_RULE,
        DINGO_JOIN_VALUES_RULE,
        DINGO_AGGREGATE_RULE,
        DINGO_AGGREGATE_SINGLE_RULE,
        DINGO_DISTRIBUTED_VALUES_RULE,
        DINGO_FILTER_RULE_DISTRIBUTED,
        DINGO_FILTER_RULE_ROOT,
        DINGO_FILTER_TABLE_SCAN_RULE,
        DINGO_EXCHANGE_ROOT_RULE,
        DINGO_GET_BY_KEYS_RULE,
        DINGO_HASH_JOIN_RULE,
        DINGO_PART_COUNT_RULE,
        DINGO_PARTITION_DELETE_RULE,
        DINGO_PART_MODIFY_RULE,
        DINGO_PART_SCAN_RULE,
        DINGO_PROJECT_RULE_DISTRIBUTED,
        DINGO_PROJECT_RULE_ROOT,
        DINGO_PROJECT_SCAN_RULE,
        DINGO_SORT_RULE,
        DINGO_UNION_RULE,
        DINGO_VALUES_RULE_DISTRIBUTED,
        DINGO_VALUES_RULE_ROOT,
        DINGO_PART_RANGE_RULE
    );

    private DingoRules() {
    }

    public static List<RelOptRule> rules() {
        return rules;
    }
}
