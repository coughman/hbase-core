/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.cloudera.cdk.hbase.data;  
@SuppressWarnings("all")
/** event record */
@org.apache.avro.specific.AvroGenerated
public class Event extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Event\",\"namespace\":\"com.cloudera.cdk.hbase.data\",\"doc\":\"event record\",\"fields\":[{\"name\":\"id\",\"type\":\"string\",\"mapping\":{\"type\":\"key\",\"value\":\"0\"}},{\"name\":\"source_system_code\",\"type\":\"string\",\"mapping\":{\"type\":\"column\",\"value\":\"meta:source_system_code\"}},{\"name\":\"event_dttm\",\"type\":\"long\",\"mapping\":{\"type\":\"column\",\"value\":\"meta:event_dttm\"}},{\"name\":\"details_text\",\"type\":\"string\",\"mapping\":{\"type\":\"column\",\"value\":\"meta:details_text\"}},{\"name\":\"status\",\"type\":\"string\",\"mapping\":{\"type\":\"column\",\"value\":\"meta:status\"}},{\"name\":\"user_id\",\"type\":\"string\",\"mapping\":{\"type\":\"column\",\"value\":\"meta:user_id\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
   private java.lang.CharSequence id;
   private java.lang.CharSequence source_system_code;
   private long event_dttm;
   private java.lang.CharSequence details_text;
   private java.lang.CharSequence status;
   private java.lang.CharSequence user_id;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use {@link \#newBuilder()}. 
   */
  public Event() {}

  /**
   * All-args constructor.
   */
  public Event(java.lang.CharSequence id, java.lang.CharSequence source_system_code, java.lang.Long event_dttm, java.lang.CharSequence details_text, java.lang.CharSequence status, java.lang.CharSequence user_id) {
    this.id = id;
    this.source_system_code = source_system_code;
    this.event_dttm = event_dttm;
    this.details_text = details_text;
    this.status = status;
    this.user_id = user_id;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return source_system_code;
    case 2: return event_dttm;
    case 3: return details_text;
    case 4: return status;
    case 5: return user_id;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.CharSequence)value$; break;
    case 1: source_system_code = (java.lang.CharSequence)value$; break;
    case 2: event_dttm = (java.lang.Long)value$; break;
    case 3: details_text = (java.lang.CharSequence)value$; break;
    case 4: status = (java.lang.CharSequence)value$; break;
    case 5: user_id = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   */
  public java.lang.CharSequence getId() {
    return id;
  }


  /**
   * Gets the value of the 'source_system_code' field.
   */
  public java.lang.CharSequence getSourceSystemCode() {
    return source_system_code;
  }


  /**
   * Gets the value of the 'event_dttm' field.
   */
  public java.lang.Long getEventDttm() {
    return event_dttm;
  }


  /**
   * Gets the value of the 'details_text' field.
   */
  public java.lang.CharSequence getDetailsText() {
    return details_text;
  }


  /**
   * Gets the value of the 'status' field.
   */
  public java.lang.CharSequence getStatus() {
    return status;
  }


  /**
   * Gets the value of the 'user_id' field.
   */
  public java.lang.CharSequence getUserId() {
    return user_id;
  }


  /** Creates a new Event RecordBuilder */
  public static com.cloudera.cdk.hbase.data.Event.Builder newBuilder() {
    return new com.cloudera.cdk.hbase.data.Event.Builder();
  }
  
  /** Creates a new Event RecordBuilder by copying an existing Builder */
  public static com.cloudera.cdk.hbase.data.Event.Builder newBuilder(com.cloudera.cdk.hbase.data.Event.Builder other) {
    return new com.cloudera.cdk.hbase.data.Event.Builder(other);
  }
  
  /** Creates a new Event RecordBuilder by copying an existing Event instance */
  public static com.cloudera.cdk.hbase.data.Event.Builder newBuilder(com.cloudera.cdk.hbase.data.Event other) {
    return new com.cloudera.cdk.hbase.data.Event.Builder(other);
  }
  
  /**
   * RecordBuilder for Event instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Event>
    implements org.apache.avro.data.RecordBuilder<Event> {

    private java.lang.CharSequence id;
    private java.lang.CharSequence source_system_code;
    private long event_dttm;
    private java.lang.CharSequence details_text;
    private java.lang.CharSequence status;
    private java.lang.CharSequence user_id;

    /** Creates a new Builder */
    private Builder() {
      super(com.cloudera.cdk.hbase.data.Event.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.cloudera.cdk.hbase.data.Event.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.source_system_code)) {
        this.source_system_code = data().deepCopy(fields()[1].schema(), other.source_system_code);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.event_dttm)) {
        this.event_dttm = data().deepCopy(fields()[2].schema(), other.event_dttm);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.details_text)) {
        this.details_text = data().deepCopy(fields()[3].schema(), other.details_text);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.status)) {
        this.status = data().deepCopy(fields()[4].schema(), other.status);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.user_id)) {
        this.user_id = data().deepCopy(fields()[5].schema(), other.user_id);
        fieldSetFlags()[5] = true;
      }
    }
    
    /** Creates a Builder by copying an existing Event instance */
    private Builder(com.cloudera.cdk.hbase.data.Event other) {
            super(com.cloudera.cdk.hbase.data.Event.SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.source_system_code)) {
        this.source_system_code = data().deepCopy(fields()[1].schema(), other.source_system_code);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.event_dttm)) {
        this.event_dttm = data().deepCopy(fields()[2].schema(), other.event_dttm);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.details_text)) {
        this.details_text = data().deepCopy(fields()[3].schema(), other.details_text);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.status)) {
        this.status = data().deepCopy(fields()[4].schema(), other.status);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.user_id)) {
        this.user_id = data().deepCopy(fields()[5].schema(), other.user_id);
        fieldSetFlags()[5] = true;
      }
    }

    /** Gets the value of the 'id' field */
    public java.lang.CharSequence getId() {
      return id;
    }
    
    /** Sets the value of the 'id' field */
    public com.cloudera.cdk.hbase.data.Event.Builder setId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'id' field has been set */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'id' field */
    public com.cloudera.cdk.hbase.data.Event.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'source_system_code' field */
    public java.lang.CharSequence getSourceSystemCode() {
      return source_system_code;
    }
    
    /** Sets the value of the 'source_system_code' field */
    public com.cloudera.cdk.hbase.data.Event.Builder setSourceSystemCode(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.source_system_code = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'source_system_code' field has been set */
    public boolean hasSourceSystemCode() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'source_system_code' field */
    public com.cloudera.cdk.hbase.data.Event.Builder clearSourceSystemCode() {
      source_system_code = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /** Gets the value of the 'event_dttm' field */
    public java.lang.Long getEventDttm() {
      return event_dttm;
    }
    
    /** Sets the value of the 'event_dttm' field */
    public com.cloudera.cdk.hbase.data.Event.Builder setEventDttm(long value) {
      validate(fields()[2], value);
      this.event_dttm = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the 'event_dttm' field has been set */
    public boolean hasEventDttm() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the 'event_dttm' field */
    public com.cloudera.cdk.hbase.data.Event.Builder clearEventDttm() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /** Gets the value of the 'details_text' field */
    public java.lang.CharSequence getDetailsText() {
      return details_text;
    }
    
    /** Sets the value of the 'details_text' field */
    public com.cloudera.cdk.hbase.data.Event.Builder setDetailsText(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.details_text = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the 'details_text' field has been set */
    public boolean hasDetailsText() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the 'details_text' field */
    public com.cloudera.cdk.hbase.data.Event.Builder clearDetailsText() {
      details_text = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /** Gets the value of the 'status' field */
    public java.lang.CharSequence getStatus() {
      return status;
    }
    
    /** Sets the value of the 'status' field */
    public com.cloudera.cdk.hbase.data.Event.Builder setStatus(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.status = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the 'status' field has been set */
    public boolean hasStatus() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the 'status' field */
    public com.cloudera.cdk.hbase.data.Event.Builder clearStatus() {
      status = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /** Gets the value of the 'user_id' field */
    public java.lang.CharSequence getUserId() {
      return user_id;
    }
    
    /** Sets the value of the 'user_id' field */
    public com.cloudera.cdk.hbase.data.Event.Builder setUserId(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.user_id = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the 'user_id' field has been set */
    public boolean hasUserId() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the 'user_id' field */
    public com.cloudera.cdk.hbase.data.Event.Builder clearUserId() {
      user_id = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    public Event build() {
      try {
        Event record = new Event();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.source_system_code = fieldSetFlags()[1] ? this.source_system_code : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.event_dttm = fieldSetFlags()[2] ? this.event_dttm : (java.lang.Long) defaultValue(fields()[2]);
        record.details_text = fieldSetFlags()[3] ? this.details_text : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.status = fieldSetFlags()[4] ? this.status : (java.lang.CharSequence) defaultValue(fields()[4]);
        record.user_id = fieldSetFlags()[5] ? this.user_id : (java.lang.CharSequence) defaultValue(fields()[5]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}