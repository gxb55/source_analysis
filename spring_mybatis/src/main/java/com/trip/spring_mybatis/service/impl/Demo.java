package com.trip.spring_mybatis.service.impl;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLExprTableSource;
import com.alibaba.druid.sql.ast.statement.SQLSelectQueryBlock;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.ast.statement.SQLTableSource;
import com.alibaba.druid.sql.visitor.SchemaStatVisitor;
import com.alibaba.druid.stat.TableStat;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.druid.util.JdbcConstants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author xbguo
 * @date 2024/7/9 20:22
 * @description TODO
 */
public class Demo {
    public static void main(String[] args) {
        String sql = "select * from tbl_zhixing_order where order_id in (?)";
        char[] charArray = sql.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : charArray) {
            if (c == '?') {
                stringBuilder.append('1');
            } else {
                stringBuilder.append(c);
            }
        }
        System.out.println(stringBuilder.toString());
        String dbType = JdbcConstants.MYSQL;

        List<SQLStatement> statementList1 = SQLUtils.parseStatements(stringBuilder.toString(), dbType);
        System.out.println(statementList1);
        SQLStatement sqlStatement = statementList1.get(0);
        System.out.println(sqlStatement);
        for (SQLStatement statement : statementList1) {
            if (statement instanceof SQLSelectStatement) {
                SchemaStatVisitor visitor = new SchemaStatVisitor(dbType);
                statement.accept(visitor);

                //解析表名
                SQLSelectStatement selectStatement = (SQLSelectStatement) statement;
                SQLSelectQueryBlock queryBlock = selectStatement.getSelect().getFirstQueryBlock();
                SQLTableSource from = queryBlock.getFrom();
                SQLExprTableSource sqlExprTableSource = (SQLExprTableSource) from;

                //查询列
                Collection<TableStat.Column> columns = visitor.getColumns();
                List<String> columnList = new ArrayList<>();
                columns.stream().forEach(row -> {
                    if (row.isSelect()) {
                        //保存select字段
                        columnList.add(row.getName());
                    }
                });


                //查询过滤条件
                List<TableStat.Condition> conditions = visitor.getConditions();
                conditions.stream().forEach(row -> {
                    String columnName = row.getColumn().getName();
                    String operator = row.getOperator();
                    System.out.println(columnName+"+"+operator);
                    List<Object> values = row.getValues();
                    System.out.println(columnName+"+"+operator+"values"+ JSONUtils.toJSONString(values));

                    if ("=".equalsIgnoreCase(operator)) {

                    } else if ("LIKE".equalsIgnoreCase(operator)) {
                    } else {
                    }
                });
            }
        }
    }
}
