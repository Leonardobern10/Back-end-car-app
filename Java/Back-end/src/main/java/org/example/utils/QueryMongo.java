package org.example.utils;

public class QueryMongo {
    public final static String FIND_BY_MODEL = "{'model': {$eq: ?0}}";
    public final static String FIND_BY_LESS_VALUE = "{ 'carValue': { $gt: ?0 } }";
    public final static String FIND_BY_VALUE = "{ 'carValue': { $eq: ?0} }";
    public final static String FIND_BY_BIGGER_VALUE = "{ 'carValue': { $gt: ?0} }";
    public final static String FIND_BY_YEAR = " { 'yearProduction': { $eq: ?0 } }";
    public final static String FIND_BY_NEWER_YEAR = " { 'yearProduction': { $lt: ?0 } }";
    public final static String FIND_BY_OLDER_YEAR = " { 'yearProduction': { $gt: ?0 } }";
    public final static String FIND_BY_PRODUCEDBY = "{'producedBy': {$eq: ?0 } }";
    public final static String FIND_BY_ENGINE_TYPE = "{'specifications.engineType':{$eq: ?0}}";
    public final static String FIND_BY_TOP_SPEED = "{'specifications.topSpeed':{$eq: ?0}}";
    public final static String FIND_BY_FEATURE = "{'features': {$eq: ?0}}";
}
