package com.sicsrobotics.util.query;

public class QueryBuilder {


    private StringBuilder sb = new StringBuilder();

    public QueryBuilder SELECT (QueryBuilder subquery){

        return null;
    }

    public ISelected SELECT (String columns){

        sb = sb.append(String.format("SELECT (%$1) ",columns));

        return new Selected();
    }

    public QueryBuilder SELECT (String columns, boolean seal){

        return null;
    }


    /// ABSTRACTION
    public interface ISelected {
        public IFrommed FROM(String schemaTableName);
        public IFrommed FROM(QueryBuilder subquery);
    }

    public interface IFrommed {
        public IWhered WHERE(String schemaTableName);

    }

    public interface IWhered{
        public IWhered AND(String condition);
        public IWhered OR (String condition);
        public IWhered BETWEEN (String condition);
    }
    public class Selected implements ISelected{

        @Override
        public IFrommed FROM(String schemaTableName) {
            return null;
        }

        @Override
        public IFrommed FROM(QueryBuilder subquery) {
            return null;
        }
    }
}
