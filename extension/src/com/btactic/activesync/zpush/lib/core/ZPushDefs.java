/*
 * ***** BEGIN LICENSE BLOCK *****
 * Z-Push port to Java
 * Copyright (C) 2025 BTACTIC, S.C.C.L.
 *
 * Z-Push - Constants' definition file (01.10.2007)
 * Copyright 2007 - 2016 Zarafa Deutschland GmbH
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Consult AGPL-3.0.txt file for details
 * ***** END LICENSE BLOCK *****
 */
package com.btactic.activesync.zpush.lib.core;

public class ZPushDefs {

    // Code Page 0: AirSync, all AS versions
    public static final String SYNC_SYNCHRONIZE = "Synchronize";
    public static final String SYNC_REPLIES = "Replies";
    public static final String SYNC_ADD = "Add";
    public static final String SYNC_MODIFY = "Modify";
    public static final String SYNC_REMOVE = "Remove";
    public static final String SYNC_FETCH = "Fetch";
    public static final String SYNC_SYNCKEY = "SyncKey";
    public static final String SYNC_CLIENTENTRYID = "ClientEntryId";
    public static final String SYNC_SERVERENTRYID = "ServerEntryId";
    public static final String SYNC_STATUS = "Status";
    public static final String SYNC_FOLDER = "Folder";
    public static final String SYNC_FOLDERTYPE = "FolderType";
    public static final String SYNC_VERSION = "Version"; // deprecated
    public static final String SYNC_FOLDERID = "FolderId";
    public static final String SYNC_GETCHANGES = "GetChanges";
    public static final String SYNC_MOREAVAILABLE = "MoreAvailable";
    public static final String SYNC_WINDOWSIZE = "WindowSize"; //MaxItems before z-push 2
    public static final String SYNC_PERFORM = "Perform";
    public static final String SYNC_OPTIONS = "Options";
    public static final String SYNC_FILTERTYPE = "FilterType";
    public static final String SYNC_TRUNCATION = "Truncation"; // 2.5
    public static final String SYNC_RTFTRUNCATION = "RtfTruncation"; // 2.5
    public static final String SYNC_CONFLICT = "Conflict";
    public static final String SYNC_FOLDERS = "Folders";
    public static final String SYNC_DATA = "Data";
    public static final String SYNC_DELETESASMOVES = "DeletesAsMoves";
    public static final String SYNC_NOTIFYGUID = "NotifyGUID";
    public static final String SYNC_SUPPORTED = "Supported";
    public static final String SYNC_SOFTDELETE = "SoftDelete";
    public static final String SYNC_MIMESUPPORT = "MIMESupport";
    public static final String SYNC_MIMETRUNCATION = "MIMETruncation";
    public static final String SYNC_NEWMESSAGE = "NewMessage";
    public static final String SYNC_WAIT = "Wait"; // Since 12.1
    public static final String SYNC_LIMIT = "Limit"; // Since 12.1
    public static final String SYNC_PARTIAL = "Partial"; // Since 12.1
    public static final String SYNC_CONVERSATIONMODE = "ConversationMode"; // Since 14.0
    public static final String SYNC_MAXITEMS = "MaxItems"; // Since 14.0
    public static final String SYNC_HEARTBEATINTERVAL = "HeartbeatInterval"; // Since 14.0

    // Code Page 1: Contacts - POOMCONTACTS, all AS versions
    public static final String SYNC_POOMCONTACTS_ANNIVERSARY = "POOMCONTACTS:Anniversary";
    public static final String SYNC_POOMCONTACTS_ASSISTANTNAME = "POOMCONTACTS:AssistantName";
    public static final String SYNC_POOMCONTACTS_ASSISTNAMEPHONENUMBER = "POOMCONTACTS:AssistnamePhoneNumber";
    public static final String SYNC_POOMCONTACTS_BIRTHDAY = "POOMCONTACTS:Birthday";
    public static final String SYNC_POOMCONTACTS_BODY = "POOMCONTACTS:Body"; // 2.5, AirSyncBase Body is used since 12.0
    public static final String SYNC_POOMCONTACTS_BODYSIZE = "POOMCONTACTS:BodySize"; // 2.5, AirSyncBase is used since version 12.0
    public static final String SYNC_POOMCONTACTS_BODYTRUNCATED = "POOMCONTACTS:BodyTruncated"; // 2.5, AirSyncBase is used since version 12.0
    public static final String SYNC_POOMCONTACTS_BUSINESS2PHONENUMBER = "POOMCONTACTS:Business2PhoneNumber";
    public static final String SYNC_POOMCONTACTS_BUSINESSCITY = "POOMCONTACTS:BusinessCity";
    public static final String SYNC_POOMCONTACTS_BUSINESSCOUNTRY = "POOMCONTACTS:BusinessCountry";
    public static final String SYNC_POOMCONTACTS_BUSINESSPOSTALCODE = "POOMCONTACTS:BusinessPostalCode";
    public static final String SYNC_POOMCONTACTS_BUSINESSSTATE = "POOMCONTACTS:BusinessState";
    public static final String SYNC_POOMCONTACTS_BUSINESSSTREET = "POOMCONTACTS:BusinessStreet";
    public static final String SYNC_POOMCONTACTS_BUSINESSFAXNUMBER = "POOMCONTACTS:BusinessFaxNumber";
    public static final String SYNC_POOMCONTACTS_BUSINESSPHONENUMBER = "POOMCONTACTS:BusinessPhoneNumber";
    public static final String SYNC_POOMCONTACTS_CARPHONENUMBER = "POOMCONTACTS:CarPhoneNumber";
    public static final String SYNC_POOMCONTACTS_CATEGORIES = "POOMCONTACTS:Categories";
    public static final String SYNC_POOMCONTACTS_CATEGORY = "POOMCONTACTS:Category";
    public static final String SYNC_POOMCONTACTS_CHILDREN = "POOMCONTACTS:Children";
    public static final String SYNC_POOMCONTACTS_CHILD = "POOMCONTACTS:Child";
    public static final String SYNC_POOMCONTACTS_COMPANYNAME = "POOMCONTACTS:CompanyName";
    public static final String SYNC_POOMCONTACTS_DEPARTMENT = "POOMCONTACTS:Department";
    public static final String SYNC_POOMCONTACTS_EMAIL1ADDRESS = "POOMCONTACTS:Email1Address";
    public static final String SYNC_POOMCONTACTS_EMAIL2ADDRESS = "POOMCONTACTS:Email2Address";
    public static final String SYNC_POOMCONTACTS_EMAIL3ADDRESS = "POOMCONTACTS:Email3Address";
    public static final String SYNC_POOMCONTACTS_FILEAS = "POOMCONTACTS:FileAs";
    public static final String SYNC_POOMCONTACTS_FIRSTNAME = "POOMCONTACTS:FirstName";
    public static final String SYNC_POOMCONTACTS_HOME2PHONENUMBER = "POOMCONTACTS:Home2PhoneNumber";
    public static final String SYNC_POOMCONTACTS_HOMECITY = "POOMCONTACTS:HomeCity";
    public static final String SYNC_POOMCONTACTS_HOMECOUNTRY = "POOMCONTACTS:HomeCountry";
    public static final String SYNC_POOMCONTACTS_HOMEPOSTALCODE = "POOMCONTACTS:HomePostalCode";
    public static final String SYNC_POOMCONTACTS_HOMESTATE = "POOMCONTACTS:HomeState";
    public static final String SYNC_POOMCONTACTS_HOMESTREET = "POOMCONTACTS:HomeStreet";
    public static final String SYNC_POOMCONTACTS_HOMEFAXNUMBER = "POOMCONTACTS:HomeFaxNumber";
    public static final String SYNC_POOMCONTACTS_HOMEPHONENUMBER = "POOMCONTACTS:HomePhoneNumber";
    public static final String SYNC_POOMCONTACTS_JOBTITLE = "POOMCONTACTS:JobTitle";
    public static final String SYNC_POOMCONTACTS_LASTNAME = "POOMCONTACTS:LastName";
    public static final String SYNC_POOMCONTACTS_MIDDLENAME = "POOMCONTACTS:MiddleName";
    public static final String SYNC_POOMCONTACTS_MOBILEPHONENUMBER = "POOMCONTACTS:MobilePhoneNumber";
    public static final String SYNC_POOMCONTACTS_OFFICELOCATION = "POOMCONTACTS:OfficeLocation";
    public static final String SYNC_POOMCONTACTS_OTHERCITY = "POOMCONTACTS:OtherCity";
    public static final String SYNC_POOMCONTACTS_OTHERCOUNTRY = "POOMCONTACTS:OtherCountry";
    public static final String SYNC_POOMCONTACTS_OTHERPOSTALCODE = "POOMCONTACTS:OtherPostalCode";
    public static final String SYNC_POOMCONTACTS_OTHERSTATE = "POOMCONTACTS:OtherState";
    public static final String SYNC_POOMCONTACTS_OTHERSTREET = "POOMCONTACTS:OtherStreet";
    public static final String SYNC_POOMCONTACTS_PAGERNUMBER = "POOMCONTACTS:PagerNumber";
    public static final String SYNC_POOMCONTACTS_RADIOPHONENUMBER = "POOMCONTACTS:RadioPhoneNumber";
    public static final String SYNC_POOMCONTACTS_SPOUSE = "POOMCONTACTS:Spouse";
    public static final String SYNC_POOMCONTACTS_SUFFIX = "POOMCONTACTS:Suffix";
    public static final String SYNC_POOMCONTACTS_TITLE = "POOMCONTACTS:Title";
    public static final String SYNC_POOMCONTACTS_WEBPAGE = "POOMCONTACTS:WebPage";
    public static final String SYNC_POOMCONTACTS_YOMICOMPANYNAME = "POOMCONTACTS:YomiCompanyName";
    public static final String SYNC_POOMCONTACTS_YOMIFIRSTNAME = "POOMCONTACTS:YomiFirstName";
    public static final String SYNC_POOMCONTACTS_YOMILASTNAME = "POOMCONTACTS:YomiLastName";
    public static final String SYNC_POOMCONTACTS_RTF = "POOMCONTACTS:Rtf"; // deprecated
    public static final String SYNC_POOMCONTACTS_PICTURE = "POOMCONTACTS:Picture";
    public static final String SYNC_POOMCONTACTS_ALIAS = "POOMCONTACTS:Alias"; // Since 14.0
    public static final String SYNC_POOMCONTACTS_WEIGHEDRANK = "POOMCONTACTS:WeightedRank"; // Since 14.0

    // Code Page 2: Email - POOMMAIL, all AS versions
    public static final String SYNC_POOMMAIL_ATTACHMENT = "POOMMAIL:Attachment"; // AirSyncBase Attachments is used since 12.0
    public static final String SYNC_POOMMAIL_ATTACHMENTS = "POOMMAIL:Attachments"; // AirSyncBase Attachments is used since 12.0
    public static final String SYNC_POOMMAIL_ATTNAME = "POOMMAIL:AttName"; // AirSyncBase Attachments is used since 12.0
    public static final String SYNC_POOMMAIL_ATTSIZE = "POOMMAIL:AttSize"; // AirSyncBase Attachments is used since 12.0
    public static final String SYNC_POOMMAIL_ATTOID = "POOMMAIL:AttOid"; // AirSyncBase Attachments is used since 12.0
    public static final String SYNC_POOMMAIL_ATTMETHOD = "POOMMAIL:AttMethod"; // AirSyncBase Attachments is used since 12.0
    public static final String SYNC_POOMMAIL_ATTREMOVED = "POOMMAIL:AttRemoved"; // AirSyncBase Attachments is used since 12.0
    public static final String SYNC_POOMMAIL_BODY = "POOMMAIL:Body"; // AirSyncBase Body is used since 12.0
    public static final String SYNC_POOMMAIL_BODYSIZE = "POOMMAIL:BodySize"; // AirSyncBase Body is used since 12.0
    public static final String SYNC_POOMMAIL_BODYTRUNCATED = "POOMMAIL:BodyTruncated"; // AirSyncBase Body is used since 12.0
    public static final String SYNC_POOMMAIL_DATERECEIVED = "POOMMAIL:DateReceived";
    public static final String SYNC_POOMMAIL_DISPLAYNAME = "POOMMAIL:DisplayName"; // AirSyncBase Attachments is used since 12.0
    public static final String SYNC_POOMMAIL_DISPLAYTO = "POOMMAIL:DisplayTo";
    public static final String SYNC_POOMMAIL_IMPORTANCE = "POOMMAIL:Importance";
    public static final String SYNC_POOMMAIL_MESSAGECLASS = "POOMMAIL:MessageClass";
    public static final String SYNC_POOMMAIL_SUBJECT = "POOMMAIL:Subject";
    public static final String SYNC_POOMMAIL_READ = "POOMMAIL:Read";
    public static final String SYNC_POOMMAIL_TO = "POOMMAIL:To";
    public static final String SYNC_POOMMAIL_CC = "POOMMAIL:Cc";
    public static final String SYNC_POOMMAIL_FROM = "POOMMAIL:From";
    public static final String SYNC_POOMMAIL_REPLY_TO = "POOMMAIL:Reply-To";
    public static final String SYNC_POOMMAIL_ALLDAYEVENT = "POOMMAIL:AllDayEvent";
    public static final String SYNC_POOMMAIL_CATEGORIES = "POOMMAIL:Categories"; // Since 14.0
    public static final String SYNC_POOMMAIL_CATEGORY = "POOMMAIL:Category"; // Since 14.0
    public static final String SYNC_POOMMAIL_DTSTAMP = "POOMMAIL:DtStamp";
    public static final String SYNC_POOMMAIL_ENDTIME = "POOMMAIL:EndTime";
    public static final String SYNC_POOMMAIL_INSTANCETYPE = "POOMMAIL:InstanceType";
    public static final String SYNC_POOMMAIL_BUSYSTATUS = "POOMMAIL:BusyStatus";
    public static final String SYNC_POOMMAIL_LOCATION = "POOMMAIL:Location"; // 2.5, 12.0, 12.1, 14.0 and 14.1. Since 16.0 AirSyncBase Location is used.
    public static final String SYNC_POOMMAIL_MEETINGREQUEST = "POOMMAIL:MeetingRequest";
    public static final String SYNC_POOMMAIL_ORGANIZER = "POOMMAIL:Organizer";
    public static final String SYNC_POOMMAIL_RECURRENCEID = "POOMMAIL:RecurrenceId";
    public static final String SYNC_POOMMAIL_REMINDER = "POOMMAIL:Reminder";
    public static final String SYNC_POOMMAIL_RESPONSEREQUESTED = "POOMMAIL:ResponseRequested";
    public static final String SYNC_POOMMAIL_RECURRENCES = "POOMMAIL:Recurrences";
    public static final String SYNC_POOMMAIL_RECURRENCE = "POOMMAIL:Recurrence";
    public static final String SYNC_POOMMAIL_TYPE = "POOMMAIL:Type";
    public static final String SYNC_POOMMAIL_UNTIL = "POOMMAIL:Until";
    public static final String SYNC_POOMMAIL_OCCURRENCES = "POOMMAIL:Occurrences";
    public static final String SYNC_POOMMAIL_INTERVAL = "POOMMAIL:Interval";
    public static final String SYNC_POOMMAIL_DAYOFWEEK = "POOMMAIL:DayOfWeek";
    public static final String SYNC_POOMMAIL_DAYOFMONTH = "POOMMAIL:DayOfMonth";
    public static final String SYNC_POOMMAIL_WEEKOFMONTH = "POOMMAIL:WeekOfMonth";
    public static final String SYNC_POOMMAIL_MONTHOFYEAR = "POOMMAIL:MonthOfYear";
    public static final String SYNC_POOMMAIL_STARTTIME = "POOMMAIL:StartTime";
    public static final String SYNC_POOMMAIL_SENSITIVITY = "POOMMAIL:Sensitivity";
    public static final String SYNC_POOMMAIL_TIMEZONE = "POOMMAIL:TimeZone";
    public static final String SYNC_POOMMAIL_GLOBALOBJID = "POOMMAIL:GlobalObjId"; // 2.5, 12.0, 12.1, 14.0 and 14.1. UID of Calendar (Code page 4) is used since 16.0
    public static final String SYNC_POOMMAIL_THREADTOPIC = "POOMMAIL:ThreadTopic";
    public static final String SYNC_POOMMAIL_MIMEDATA = "POOMMAIL:MIMEData"; // 2.5
    public static final String SYNC_POOMMAIL_MIMETRUNCATED = "POOMMAIL:MIMETruncated"; // 2.5
    public static final String SYNC_POOMMAIL_MIMESIZE = "POOMMAIL:MIMESize";
    public static final String SYNC_POOMMAIL_INTERNETCPID = "POOMMAIL:InternetCPID";
    public static final String SYNC_POOMMAIL_FLAG = "POOMMAIL:Flag"; // Since 12.0
    public static final String SYNC_POOMMAIL_FLAGSTATUS = "POOMMAIL:FlagStatus"; // Since 12.0
    public static final String SYNC_POOMMAIL_CONTENTCLASS = "POOMMAIL:ContentClass"; // Since 12.0
    public static final String SYNC_POOMMAIL_FLAGTYPE = "POOMMAIL:FlagType"; // Since 12.0
    public static final String SYNC_POOMMAIL_COMPLETETIME = "POOMMAIL:CompleteTime"; //Since 12.0
    public static final String SYNC_POOMMAIL_DISALLOWNEWTIMEPROPOSAL = "POOMMAIL:DisallowNewTimeProposal"; // Since 14.0
    // only for internal use - never to be streamed to the mobile
    public static final String SYNC_POOMMAIL_IGNORE_DISPLAYCC = "POOMMAIL:IgnoreDisplayCC"; // Since 16.0
    public static final String SYNC_POOMMAIL_IGNORE_DISPLAYBCC = "POOMMAIL:IgnoreDisplayBCC"; // Since 16.0
    public static final String SYNC_POOMMAIL_IGNORE_PARENTSOURCEKEY = "POOMMAIL:IgnoreParentSourceKey"; // Since 16.0

    // Code Page 3: AirNotify - AIRNOTIFY, no longer in use
    public static final String SYNC_AIRNOTIFY_NOTIFY = "AirNotify:Notify";
    public static final String SYNC_AIRNOTIFY_NOTIFICATION = "AirNotify:Notification";
    public static final String SYNC_AIRNOTIFY_VERSION = "AirNotify:Version";
    public static final String SYNC_AIRNOTIFY_LIFETIME = "AirNotify:Lifetime";
    public static final String SYNC_AIRNOTIFY_DEVICEINFO = "AirNotify:DeviceInfo";
    public static final String SYNC_AIRNOTIFY_ENABLE = "AirNotify:Enable";
    public static final String SYNC_AIRNOTIFY_FOLDER = "AirNotify:Folder";
    public static final String SYNC_AIRNOTIFY_SERVERENTRYID = "AirNotify:ServerEntryId";
    public static final String SYNC_AIRNOTIFY_DEVICEADDRESS = "AirNotify:DeviceAddress";
    public static final String SYNC_AIRNOTIFY_VALIDCARRIERPROFILES = "AirNotify:ValidCarrierProfiles";
    public static final String SYNC_AIRNOTIFY_CARRIERPROFILE = "AirNotify:CarrierProfile";
    public static final String SYNC_AIRNOTIFY_STATUS = "AirNotify:Status";
    public static final String SYNC_AIRNOTIFY_REPLIES = "AirNotify:Replies";

    // Actually not used in the source code. Kept here for historical reasons
    // with a different JAVA name that conforms to Java variable naming
    // define("SYNC_AIRNOTIFY_VERSION='1.1'","AirNotify:Version='1.1'");
    public static final String SYNC_AIRNOTIFY_VERSION_EQUALS_1_1 = "AirNotify:Version='1.1'";

    public static final String SYNC_AIRNOTIFY_DEVICES = "AirNotify:Devices";
    public static final String SYNC_AIRNOTIFY_DEVICE = "AirNotify:Device";
    public static final String SYNC_AIRNOTIFY_ID = "AirNotify:Id";
    public static final String SYNC_AIRNOTIFY_EXPIRY = "AirNotify:Expiry";
    public static final String SYNC_AIRNOTIFY_NOTIFYGUID = "AirNotify:NotifyGUID";

    // Code Page 4: Calendar - POOMCAL, all AS versions
    public static final String SYNC_POOMCAL_TIMEZONE = "POOMCAL:Timezone";
    public static final String SYNC_POOMCAL_ALLDAYEVENT = "POOMCAL:AllDayEvent";
    public static final String SYNC_POOMCAL_ATTENDEES = "POOMCAL:Attendees";
    public static final String SYNC_POOMCAL_ATTENDEE = "POOMCAL:Attendee";
    public static final String SYNC_POOMCAL_EMAIL = "POOMCAL:Email";
    public static final String SYNC_POOMCAL_NAME = "POOMCAL:Name";
    public static final String SYNC_POOMCAL_BODY = "POOMCAL:Body"; // AirSyncBase Body is used since 12.0
    public static final String SYNC_POOMCAL_BODYTRUNCATED = "POOMCAL:BodyTruncated"; // AirSyncBase Body is used since 12.0
    public static final String SYNC_POOMCAL_BUSYSTATUS = "POOMCAL:BusyStatus";
    public static final String SYNC_POOMCAL_CATEGORIES = "POOMCAL:Categories";
    public static final String SYNC_POOMCAL_CATEGORY = "POOMCAL:Category";
    public static final String SYNC_POOMCAL_RTF = "POOMCAL:Rtf"; // deprecated
    public static final String SYNC_POOMCAL_DTSTAMP = "POOMCAL:DtStamp";
    public static final String SYNC_POOMCAL_ENDTIME = "POOMCAL:EndTime";
    public static final String SYNC_POOMCAL_EXCEPTION = "POOMCAL:Exception";
    public static final String SYNC_POOMCAL_EXCEPTIONS = "POOMCAL:Exceptions";
    public static final String SYNC_POOMCAL_DELETED = "POOMCAL:Deleted";
    public static final String SYNC_POOMCAL_EXCEPTIONSTARTTIME = "POOMCAL:ExceptionStartTime"; // 2.5, 12.0, 12.1, 14.0 and 14.1.
    public static final String SYNC_POOMCAL_LOCATION = "POOMCAL:Location"; // 2.5, 12.0, 12.1, 14.0 and 14.1. Since 16.0 AirSyncBase Location is used.
    public static final String SYNC_POOMCAL_MEETINGSTATUS = "POOMCAL:MeetingStatus";
    public static final String SYNC_POOMCAL_ORGANIZEREMAIL = "POOMCAL:OrganizerEmail";
    public static final String SYNC_POOMCAL_ORGANIZERNAME = "POOMCAL:OrganizerName";
    public static final String SYNC_POOMCAL_RECURRENCE = "POOMCAL:Recurrence";
    public static final String SYNC_POOMCAL_TYPE = "POOMCAL:Type";
    public static final String SYNC_POOMCAL_UNTIL = "POOMCAL:Until";
    public static final String SYNC_POOMCAL_OCCURRENCES = "POOMCAL:Occurrences";
    public static final String SYNC_POOMCAL_INTERVAL = "POOMCAL:Interval";
    public static final String SYNC_POOMCAL_DAYOFWEEK = "POOMCAL:DayOfWeek";
    public static final String SYNC_POOMCAL_DAYOFMONTH = "POOMCAL:DayOfMonth";
    public static final String SYNC_POOMCAL_WEEKOFMONTH = "POOMCAL:WeekOfMonth";
    public static final String SYNC_POOMCAL_MONTHOFYEAR = "POOMCAL:MonthOfYear";
    public static final String SYNC_POOMCAL_REMINDER = "POOMCAL:Reminder";
    public static final String SYNC_POOMCAL_SENSITIVITY = "POOMCAL:Sensitivity";
    public static final String SYNC_POOMCAL_SUBJECT = "POOMCAL:Subject";
    public static final String SYNC_POOMCAL_STARTTIME = "POOMCAL:StartTime";
    public static final String SYNC_POOMCAL_UID = "POOMCAL:UID";
    public static final String SYNC_POOMCAL_ATTENDEESTATUS = "POOMCAL:Attendee_Status"; // Since 12.0
    public static final String SYNC_POOMCAL_ATTENDEETYPE = "POOMCAL:Attendee_Type"; // Since 12.0
    public static final String SYNC_POOMCAL_ATTACHMENT = "POOMCAL:Attachment"; // Not defined / deprecated
    public static final String SYNC_POOMCAL_ATTACHMENTS = "POOMCAL:Attachments"; // Not defined / deprecated
    public static final String SYNC_POOMCAL_ATTNAME = "POOMCAL:AttName"; // Not defined / deprecated
    public static final String SYNC_POOMCAL_ATTSIZE = "POOMCAL:AttSize"; // Not defined / deprecated
    public static final String SYNC_POOMCAL_ATTOID = "POOMCAL:AttOid"; // Not defined / deprecated
    public static final String SYNC_POOMCAL_ATTMETHOD = "POOMCAL:AttMethod"; // Not defined / deprecated
    public static final String SYNC_POOMCAL_ATTREMOVED = "POOMCAL:AttRemoved"; // Not defined / deprecated
    public static final String SYNC_POOMCAL_DISPLAYNAME = "POOMCAL:DisplayName"; // Not defined / deprecated
    public static final String SYNC_POOMCAL_DISALLOWNEWTIMEPROPOSAL = "POOMCAL:DisallowNewTimeProposal"; // Since 14.0
    public static final String SYNC_POOMCAL_RESPONSEREQUESTED = "POOMCAL:ResponseRequested"; // Since 14.0
    public static final String SYNC_POOMCAL_APPOINTMENTREPLYTIME = "POOMCAL:AppointmentReplyTime"; // Since 14.0
    public static final String SYNC_POOMCAL_RESPONSETYPE = "POOMCAL:ResponseType"; // Since 14.0
    public static final String SYNC_POOMCAL_CALENDARTYPE = "POOMCAL:CalendarType"; // Since 14.0
    public static final String SYNC_POOMCAL_ISLEAPMONTH = "POOMCAL:IsLeapMonth"; // Since 14.0
    public static final String SYNC_POOMCAL_FIRSTDAYOFWEEK = "POOMCAL:FirstDayOfWeek"; // Since 14.1
    public static final String SYNC_POOMCAL_ONLINEMEETINGCONFLINK = "POOMCAL:OnlineMeetingConfLink"; // Since 14.1
    public static final String SYNC_POOMCAL_ONLINEMEETINGEXTERNALLINK = "POOMCAL:OnlineMeetingExternalLink"; // Since 14.0
    public static final String SYNC_POOMCAL_CLIENTUID = "POOMCAL:ClientUid"; // Since 16.0

    // Code Page 5: Move, all AS versions
    public static final String SYNC_MOVE_MOVES = "Move:Moves";
    public static final String SYNC_MOVE_MOVE = "Move:Move";
    public static final String SYNC_MOVE_SRCMSGID = "Move:SrcMsgId";
    public static final String SYNC_MOVE_SRCFLDID = "Move:SrcFldId";
    public static final String SYNC_MOVE_DSTFLDID = "Move:DstFldId";
    public static final String SYNC_MOVE_RESPONSE = "Move:Response";
    public static final String SYNC_MOVE_STATUS = "Move:Status";
    public static final String SYNC_MOVE_DSTMSGID = "Move:DstMsgId";

    // Code Page 6: GetItemEstimate, all AS versions
    public static final String SYNC_GETITEMESTIMATE_GETITEMESTIMATE = "GetItemEstimate:GetItemEstimate";
    public static final String SYNC_GETITEMESTIMATE_VERSION = "GetItemEstimate:Version"; // deprecated
    public static final String SYNC_GETITEMESTIMATE_FOLDERS = "GetItemEstimate:Folders";
    public static final String SYNC_GETITEMESTIMATE_FOLDER = "GetItemEstimate:Folder";
    public static final String SYNC_GETITEMESTIMATE_FOLDERTYPE = "GetItemEstimate:FolderType"; // AirSync Class(SYNC_FOLDERTYPE) is used since AS 14.0
    public static final String SYNC_GETITEMESTIMATE_FOLDERID = "GetItemEstimate:FolderId";
    public static final String SYNC_GETITEMESTIMATE_DATETIME = "GetItemEstimate:DateTime"; // deprecated
    public static final String SYNC_GETITEMESTIMATE_ESTIMATE = "GetItemEstimate:Estimate";
    public static final String SYNC_GETITEMESTIMATE_RESPONSE = "GetItemEstimate:Response";
    public static final String SYNC_GETITEMESTIMATE_STATUS = "GetItemEstimate:Status";

    // Code Page 7: FolderHierarchy, all AS versions
    public static final String SYNC_FOLDERHIERARCHY_FOLDERS = "FolderHierarchy:Folders"; // 2.5, 12.0 and 12.1
    public static final String SYNC_FOLDERHIERARCHY_FOLDER = "FolderHierarchy:Folder"; // 2.5, 12.0 and 12.1
    public static final String SYNC_FOLDERHIERARCHY_DISPLAYNAME = "FolderHierarchy:DisplayName";
    public static final String SYNC_FOLDERHIERARCHY_SERVERENTRYID = "FolderHierarchy:ServerEntryId";
    public static final String SYNC_FOLDERHIERARCHY_PARENTID = "FolderHierarchy:ParentId";
    public static final String SYNC_FOLDERHIERARCHY_TYPE = "FolderHierarchy:Type";
    public static final String SYNC_FOLDERHIERARCHY_RESPONSE = "FolderHierarchy:Response"; // deprecated
    public static final String SYNC_FOLDERHIERARCHY_STATUS = "FolderHierarchy:Status";
    public static final String SYNC_FOLDERHIERARCHY_CONTENTCLASS = "FolderHierarchy:ContentClass"; // deprecated
    public static final String SYNC_FOLDERHIERARCHY_CHANGES = "FolderHierarchy:Changes";
    public static final String SYNC_FOLDERHIERARCHY_ADD = "FolderHierarchy:Add";
    public static final String SYNC_FOLDERHIERARCHY_REMOVE = "FolderHierarchy:Remove";
    public static final String SYNC_FOLDERHIERARCHY_UPDATE = "FolderHierarchy:Update";
    public static final String SYNC_FOLDERHIERARCHY_SYNCKEY = "FolderHierarchy:SyncKey";
    public static final String SYNC_FOLDERHIERARCHY_FOLDERCREATE = "FolderHierarchy:FolderCreate";
    public static final String SYNC_FOLDERHIERARCHY_FOLDERDELETE = "FolderHierarchy:FolderDelete";
    public static final String SYNC_FOLDERHIERARCHY_FOLDERUPDATE = "FolderHierarchy:FolderUpdate";
    public static final String SYNC_FOLDERHIERARCHY_FOLDERSYNC = "FolderHierarchy:FolderSync";
    public static final String SYNC_FOLDERHIERARCHY_COUNT = "FolderHierarchy:Count";
    public static final String SYNC_FOLDERHIERARCHY_VERSION = "FolderHierarchy:Version"; // Not defined / deprecated
    // only for internal use - never to be streamed to the mobile
    public static final String SYNC_FOLDERHIERARCHY_IGNORE_STORE = "FolderHierarchy:IgnoreStore";
    public static final String SYNC_FOLDERHIERARCHY_IGNORE_NOBCKENDFLD = "FolderHierarchy:IgnoreNoBackendFolder";
    public static final String SYNC_FOLDERHIERARCHY_IGNORE_BACKENDID = "FolderHierarchy:IgnoreBackendId";
    public static final String SYNC_FOLDERHIERARCHY_IGNORE_FLAGS = "FolderHierarchy:IgnoreFlags";
    public static final String SYNC_FOLDERHIERARCHY_IGNORE_TYPEREAL = "FolderHierarchy:TypeReal";

    // Code Page 8: MeetingResponse, all AS versions
    public static final String SYNC_MEETINGRESPONSE_CALENDARID = "MeetingResponse:CalendarId";
    public static final String SYNC_MEETINGRESPONSE_FOLDERID = "MeetingResponse:FolderId";
    public static final String SYNC_MEETINGRESPONSE_MEETINGRESPONSE = "MeetingResponse:MeetingResponse";
    public static final String SYNC_MEETINGRESPONSE_REQUESTID = "MeetingResponse:RequestId";
    public static final String SYNC_MEETINGRESPONSE_REQUEST = "MeetingResponse:Request";
    public static final String SYNC_MEETINGRESPONSE_RESULT = "MeetingResponse:Result";
    public static final String SYNC_MEETINGRESPONSE_STATUS = "MeetingResponse:Status";
    public static final String SYNC_MEETINGRESPONSE_USERRESPONSE = "MeetingResponse:UserResponse";
    public static final String SYNC_MEETINGRESPONSE_VERSION = "MeetingResponse:Version"; // Not defined / deprecated
    public static final String SYNC_MEETINGRESPONSE_INSTANCEID = "MeetingResponse:InstanceId"; // Since AS 14.1
    public static final String SYNC_MEETINGRESPONSE_PROPOSEDSTARTTIME = "MeetingResponse:ProposedStartTime"; // Since AS 16.1
    public static final String SYNC_MEETINGRESPONSE_PROPOSEDENDTIME = "MeetingResponse:ProposedEndTime"; // Since AS 16.1
    public static final String SYNC_MEETINGRESPONSE_SENDRESPONSE = "MeetingResponse:SendResponse"; // Since AS 16.0

    // Code Page 9: Tasks - POOMTASKS, all AS versions
    public static final String SYNC_POOMTASKS_BODY = "POOMTASKS:Body"; // AirSyncBase Body is used since 12.0
    public static final String SYNC_POOMTASKS_BODYSIZE = "POOMTASKS:BodySize"; // AirSyncBase Body is used since 12.0
    public static final String SYNC_POOMTASKS_BODYTRUNCATED = "POOMTASKS:BodyTruncated"; // AirSyncBase Body is used since 12.0
    public static final String SYNC_POOMTASKS_CATEGORIES = "POOMTASKS:Categories";
    public static final String SYNC_POOMTASKS_CATEGORY = "POOMTASKS:Category";
    public static final String SYNC_POOMTASKS_COMPLETE = "POOMTASKS:Complete";
    public static final String SYNC_POOMTASKS_DATECOMPLETED = "POOMTASKS:DateCompleted";
    public static final String SYNC_POOMTASKS_DUEDATE = "POOMTASKS:DueDate";
    public static final String SYNC_POOMTASKS_UTCDUEDATE = "POOMTASKS:UtcDueDate";
    public static final String SYNC_POOMTASKS_IMPORTANCE = "POOMTASKS:Importance";
    public static final String SYNC_POOMTASKS_RECURRENCE = "POOMTASKS:Recurrence";
    public static final String SYNC_POOMTASKS_TYPE = "POOMTASKS:Type";
    public static final String SYNC_POOMTASKS_START = "POOMTASKS:Start";
    public static final String SYNC_POOMTASKS_UNTIL = "POOMTASKS:Until";
    public static final String SYNC_POOMTASKS_OCCURRENCES = "POOMTASKS:Occurrences";
    public static final String SYNC_POOMTASKS_INTERVAL = "POOMTASKS:Interval";
    public static final String SYNC_POOMTASKS_DAYOFWEEK = "POOMTASKS:DayOfWeek";
    public static final String SYNC_POOMTASKS_DAYOFMONTH = "POOMTASKS:DayOfMonth";
    public static final String SYNC_POOMTASKS_WEEKOFMONTH = "POOMTASKS:WeekOfMonth";
    public static final String SYNC_POOMTASKS_MONTHOFYEAR = "POOMTASKS:MonthOfYear";
    public static final String SYNC_POOMTASKS_REGENERATE = "POOMTASKS:Regenerate";
    public static final String SYNC_POOMTASKS_DEADOCCUR = "POOMTASKS:DeadOccur";
    public static final String SYNC_POOMTASKS_REMINDERSET = "POOMTASKS:ReminderSet";
    public static final String SYNC_POOMTASKS_REMINDERTIME = "POOMTASKS:ReminderTime";
    public static final String SYNC_POOMTASKS_SENSITIVITY = "POOMTASKS:Sensitivity";
    public static final String SYNC_POOMTASKS_STARTDATE = "POOMTASKS:StartDate";
    public static final String SYNC_POOMTASKS_UTCSTARTDATE = "POOMTASKS:UtcStartDate";
    public static final String SYNC_POOMTASKS_SUBJECT = "POOMTASKS:Subject";
    public static final String SYNC_POOMTASKS_RTF = "POOMTASKS:Rtf";
    public static final String SYNC_POOMTASKS_ORDINALDATE = "POOMTASKS:OrdinalDate"; // Since 12.0
    public static final String SYNC_POOMTASKS_SUBORDINALDATE = "POOMTASKS:SubOrdinalDate"; // Since 12.0
    public static final String SYNC_POOMTASKS_CALENDARTYPE = "POOMTASKS:CalendarType"; // Since 14.0
    public static final String SYNC_POOMTASKS_ISLEAPMONTH = "POOMTASKS:IsLeapMonth"; // Since 14.0
    public static final String SYNC_POOMTASKS_FIRSTDAYOFWEEK = "POOMTASKS:FirstDayOfWeek"; // Since 14.0

    // Code Page 10: ResolveRecipients, all AS versions
    public static final String SYNC_RESOLVERECIPIENTS_RESOLVERECIPIENTS = "ResolveRecipients:ResolveRecipients";
    public static final String SYNC_RESOLVERECIPIENTS_RESPONSE = "ResolveRecipients:Response";
    public static final String SYNC_RESOLVERECIPIENTS_STATUS = "ResolveRecipients:Status";
    public static final String SYNC_RESOLVERECIPIENTS_TYPE = "ResolveRecipients:Type";
    public static final String SYNC_RESOLVERECIPIENTS_RECIPIENT = "ResolveRecipients:Recipient";
    public static final String SYNC_RESOLVERECIPIENTS_DISPLAYNAME = "ResolveRecipients:DisplayName";
    public static final String SYNC_RESOLVERECIPIENTS_EMAILADDRESS = "ResolveRecipients:EmailAddress";
    public static final String SYNC_RESOLVERECIPIENTS_CERTIFICATES = "ResolveRecipients:Certificates";
    public static final String SYNC_RESOLVERECIPIENTS_CERTIFICATE = "ResolveRecipients:Certificate";
    public static final String SYNC_RESOLVERECIPIENTS_MINICERTIFICATE = "ResolveRecipients:MiniCertificate";
    public static final String SYNC_RESOLVERECIPIENTS_OPTIONS = "ResolveRecipients:Options";
    public static final String SYNC_RESOLVERECIPIENTS_TO = "ResolveRecipients:To";
    public static final String SYNC_RESOLVERECIPIENTS_CERTIFICATERETRIEVAL = "ResolveRecipients:CertificateRetrieval";
    public static final String SYNC_RESOLVERECIPIENTS_RECIPIENTCOUNT = "ResolveRecipients:RecipientCount";
    public static final String SYNC_RESOLVERECIPIENTS_MAXCERTIFICATES = "ResolveRecipients:MaxCertificates";
    public static final String SYNC_RESOLVERECIPIENTS_MAXAMBIGUOUSRECIPIENTS = "ResolveRecipients:MaxAmbiguousRecipients";
    public static final String SYNC_RESOLVERECIPIENTS_CERTIFICATECOUNT = "ResolveRecipients:CertificateCount";
    public static final String SYNC_RESOLVERECIPIENTS_AVAILABILITY = "ResolveRecipients:Availability"; // Since 14.0
    public static final String SYNC_RESOLVERECIPIENTS_STARTTIME = "ResolveRecipients:StartTime"; // Since 14.0
    public static final String SYNC_RESOLVERECIPIENTS_ENDTIME = "ResolveRecipients:EndTime"; // Since 14.0
    public static final String SYNC_RESOLVERECIPIENTS_MERGEDFREEBUSY = "ResolveRecipients:MergedFreeBusy"; // Since 14.0
    public static final String SYNC_RESOLVERECIPIENTS_PICTURE = "ResolveRecipients:Picture"; // Since 14.1
    public static final String SYNC_RESOLVERECIPIENTS_MAXSIZE = "ResolveRecipients:MaxSize"; // Since 14.1
    public static final String SYNC_RESOLVERECIPIENTS_DATA = "ResolveRecipients:Data"; // Since 14.1
    public static final String SYNC_RESOLVERECIPIENTS_MAXPICTURES = "ResolveRecipients:MaxPictures"; // Since 14.1

    // Code Page 11: ValidateCert, all AS versions
    public static final String SYNC_VALIDATECERT_VALIDATECERT = "ValidateCert:ValidateCert";
    public static final String SYNC_VALIDATECERT_CERTIFICATES = "ValidateCert:Certificates";
    public static final String SYNC_VALIDATECERT_CERTIFICATE = "ValidateCert:Certificate";
    public static final String SYNC_VALIDATECERT_CERTIFICATECHAIN = "ValidateCert:CertificateChain";
    public static final String SYNC_VALIDATECERT_CHECKCRL = "ValidateCert:CheckCRL";
    public static final String SYNC_VALIDATECERT_STATUS = "ValidateCert:Status";

    // Code Page 12: Contacts2 - POOMCONTACTS2, all AS versions
    public static final String SYNC_POOMCONTACTS2_CUSTOMERID = "POOMCONTACTS2:CustomerId";
    public static final String SYNC_POOMCONTACTS2_GOVERNMENTID = "POOMCONTACTS2:GovernmentId";
    public static final String SYNC_POOMCONTACTS2_IMADDRESS = "POOMCONTACTS2:IMAddress";
    public static final String SYNC_POOMCONTACTS2_IMADDRESS2 = "POOMCONTACTS2:IMAddress2";
    public static final String SYNC_POOMCONTACTS2_IMADDRESS3 = "POOMCONTACTS2:IMAddress3";
    public static final String SYNC_POOMCONTACTS2_MANAGERNAME = "POOMCONTACTS2:ManagerName";
    public static final String SYNC_POOMCONTACTS2_COMPANYMAINPHONE = "POOMCONTACTS2:CompanyMainPhone";
    public static final String SYNC_POOMCONTACTS2_ACCOUNTNAME = "POOMCONTACTS2:AccountName";
    public static final String SYNC_POOMCONTACTS2_NICKNAME = "POOMCONTACTS2:NickName";
    public static final String SYNC_POOMCONTACTS2_MMS = "POOMCONTACTS2:MMS";

    // Code Page 13: Ping, all AS versions
    public static final String SYNC_PING_PING = "Ping:Ping";
    public static final String SYNC_PING_STATUS = "Ping:Status";
    public static final String SYNC_PING_LIFETIME = "Ping:LifeTime";
    public static final String SYNC_PING_FOLDERS = "Ping:Folders";
    public static final String SYNC_PING_FOLDER = "Ping:Folder";
    public static final String SYNC_PING_SERVERENTRYID = "Ping:ServerEntryId";
    public static final String SYNC_PING_FOLDERTYPE = "Ping:FolderType";
    public static final String SYNC_PING_MAXFOLDERS = "Ping:MaxFolders";
    public static final String SYNC_PING_VERSION = "Ping:Version"; // not defined / deprecated

    // Code Page 14: Provision, all AS versions
    public static final String SYNC_PROVISION_PROVISION = "Provision:Provision";
    public static final String SYNC_PROVISION_POLICIES = "Provision:Policies";
    public static final String SYNC_PROVISION_POLICY = "Provision:Policy";
    public static final String SYNC_PROVISION_POLICYTYPE = "Provision:PolicyType";
    public static final String SYNC_PROVISION_POLICYKEY = "Provision:PolicyKey";
    public static final String SYNC_PROVISION_DATA = "Provision:Data";
    public static final String SYNC_PROVISION_STATUS = "Provision:Status";
    public static final String SYNC_PROVISION_REMOTEWIPE = "Provision:RemoteWipe";
    public static final String SYNC_PROVISION_EASPROVISIONDOC = "Provision:EASProvisionDoc"; // Since AS 12.0
    public static final String SYNC_PROVISION_DEVPWENABLED = "Provision:DevicePasswordEnabled"; // Since AS 12.0
    public static final String SYNC_PROVISION_ALPHANUMPWREQ = "Provision:AlphanumericDevicePasswordRequired"; // Since AS 12.0
    public static final String SYNC_PROVISION_DEVENCENABLED = "Provision:DeviceEncryptionEnabled"; // Since AS 12.1
    public static final String SYNC_PROVISION_REQSTORAGECARDENC = "Provision:RequireStorageCardEncryption"; // Since AS 12.1
    public static final String SYNC_PROVISION_PWRECOVERYENABLED = "Provision:PasswordRecoveryEnabled"; // Since AS 12.0
    public static final String SYNC_PROVISION_DOCBROWSEENABLED = "Provision:DocumentBrowseEnabled"; // deprecated
    public static final String SYNC_PROVISION_ATTENABLED = "Provision:AttachmentsEnabled"; // Since AS 12.0
    public static final String SYNC_PROVISION_MINDEVPWLENGTH = "Provision:MinDevicePasswordLength"; // Since AS 12.0
    public static final String SYNC_PROVISION_MAXINACTTIMEDEVLOCK = "Provision:MaxInactivityTimeDeviceLock"; // Since AS 12.0
    public static final String SYNC_PROVISION_MAXDEVPWFAILEDATTEMPTS = "Provision:MaxDevicePasswordFailedAttempts"; // Since AS 12.0
    public static final String SYNC_PROVISION_MAXATTSIZE = "Provision:MaxAttachmentSize"; // Since AS 12.0
    public static final String SYNC_PROVISION_ALLOWSIMPLEDEVPW = "Provision:AllowSimpleDevicePassword"; // Since AS 12.0
    public static final String SYNC_PROVISION_DEVPWEXPIRATION = "Provision:DevicePasswordExpiration"; // Since AS 12.0
    public static final String SYNC_PROVISION_DEVPWHISTORY = "Provision:DevicePasswordHistory"; // Since AS 12.0
    public static final String SYNC_PROVISION_ALLOWSTORAGECARD = "Provision:AllowStorageCard"; // Since AS 12.1
    public static final String SYNC_PROVISION_ALLOWCAM = "Provision:AllowCamera"; // Since AS 12.1
    public static final String SYNC_PROVISION_REQDEVENC = "Provision:RequireDeviceEncryption"; // Since AS 12.1
    public static final String SYNC_PROVISION_ALLOWUNSIGNEDAPPS = "Provision:AllowUnsignedApplications"; // Since AS 12.1
    public static final String SYNC_PROVISION_ALLOWUNSIGNEDINSTALLATIONPACKAGES = "Provision:AllowUnsignedInstallationPackages"; // Since AS 12.1
    public static final String SYNC_PROVISION_MINDEVPWCOMPLEXCHARS = "Provision:MinDevicePasswordComplexCharacters"; // Since AS 12.1
    public static final String SYNC_PROVISION_ALLOWWIFI = "Provision:AllowWiFi"; // Since AS 12.1
    public static final String SYNC_PROVISION_ALLOWTEXTMESSAGING = "Provision:AllowTextMessaging"; // Since AS 12.1
    public static final String SYNC_PROVISION_ALLOWPOPIMAPEMAIL = "Provision:AllowPOPIMAPEmail"; // Since AS 12.1
    public static final String SYNC_PROVISION_ALLOWBLUETOOTH = "Provision:AllowBluetooth"; // Since AS 12.1
    public static final String SYNC_PROVISION_ALLOWIRDA = "Provision:AllowIrDA"; // Since AS 12.1
    public static final String SYNC_PROVISION_REQMANUALSYNCWHENROAM = "Provision:RequireManualSyncWhenRoaming"; // Since AS 12.1
    public static final String SYNC_PROVISION_ALLOWDESKTOPSYNC = "Provision:AllowDesktopSync"; // Since AS 12.1
    public static final String SYNC_PROVISION_MAXCALAGEFILTER = "Provision:MaxCalendarAgeFilter"; // Since AS 12.1
    public static final String SYNC_PROVISION_ALLOWHTMLEMAIL = "Provision:AllowHTMLEmail"; // Since AS 12.1
    public static final String SYNC_PROVISION_MAXEMAILAGEFILTER = "Provision:MaxEmailAgeFilter"; // Since AS 12.1
    public static final String SYNC_PROVISION_MAXEMAILBODYTRUNCSIZE = "Provision:MaxEmailBodyTruncationSize"; // Since AS 12.1
    public static final String SYNC_PROVISION_MAXEMAILHTMLBODYTRUNCSIZE = "Provision:MaxEmailHTMLBodyTruncationSize"; // Since AS 12.1
    public static final String SYNC_PROVISION_REQSIGNEDSMIMEMESSAGES = "Provision:RequireSignedSMIMEMessages"; // Since AS 12.1
    public static final String SYNC_PROVISION_REQENCSMIMEMESSAGES = "Provision:RequireEncryptedSMIMEMessages"; // Since AS 12.1
    public static final String SYNC_PROVISION_REQSIGNEDSMIMEALGORITHM = "Provision:RequireSignedSMIMEAlgorithm"; // Since AS 12.1
    public static final String SYNC_PROVISION_REQENCSMIMEALGORITHM = "Provision:RequireEncryptionSMIMEAlgorithm"; // Since AS 12.1
    public static final String SYNC_PROVISION_ALLOWSMIMEENCALGORITHNEG = "Provision:AllowSMIMEEncryptionAlgorithmNegotiation"; // Since AS 12.1
    public static final String SYNC_PROVISION_ALLOWSMIMESOFTCERTS = "Provision:AllowSMIMESoftCerts"; // Since AS 12.1
    public static final String SYNC_PROVISION_ALLOWBROWSER = "Provision:AllowBrowser"; // Since AS 12.1
    public static final String SYNC_PROVISION_ALLOWCONSUMEREMAIL = "Provision:AllowConsumerEmail"; // Since AS 12.1
    public static final String SYNC_PROVISION_ALLOWREMOTEDESKTOP = "Provision:AllowRemoteDesktop"; // Since AS 12.1
    public static final String SYNC_PROVISION_ALLOWINTERNETSHARING = "Provision:AllowInternetSharing"; // Since AS 12.1
    public static final String SYNC_PROVISION_UNAPPROVEDINROMAPPLIST = "Provision:UnapprovedInROMApplicationList"; // Since AS 12.1
    public static final String SYNC_PROVISION_APPNAME = "Provision:ApplicationName"; // Since AS 12.1
    public static final String SYNC_PROVISION_APPROVEDAPPLIST = "Provision:ApprovedApplicationList"; // Since AS 12.1
    public static final String SYNC_PROVISION_HASH = "Provision:Hash"; // Since AS 12.1
    public static final String SYNC_PROVISION_ACCOUNTONLYREMOTEWIPE = "Provision:AccountOnlyRemoteWipe"; // Since AS 16.1
    // only for internal use - never to be streamed to the mobile
    public static final String SYNC_PROVISION_POLICYNAME = "Provision:PolicyName";

    // Code Page 15: Search, all AS versions
    public static final String SYNC_SEARCH_SEARCH = "Search:Search";
    public static final String SYNC_SEARCH_STORE = "Search:Store";
    public static final String SYNC_SEARCH_NAME = "Search:Name";
    public static final String SYNC_SEARCH_QUERY = "Search:Query";
    public static final String SYNC_SEARCH_OPTIONS = "Search:Options";
    public static final String SYNC_SEARCH_RANGE = "Search:Range";
    public static final String SYNC_SEARCH_STATUS = "Search:Status";
    public static final String SYNC_SEARCH_RESPONSE = "Search:Response";
    public static final String SYNC_SEARCH_RESULT = "Search:Result";
    public static final String SYNC_SEARCH_PROPERTIES = "Search:Properties";
    public static final String SYNC_SEARCH_TOTAL = "Search:Total";
    public static final String SYNC_SEARCH_EQUALTO = "Search:EqualTo"; // Since AS 12.0
    public static final String SYNC_SEARCH_VALUE = "Search:Value"; // Since AS 12.0
    public static final String SYNC_SEARCH_AND = "Search:And"; // Since AS 12.0
    public static final String SYNC_SEARCH_OR = "Search:Or"; // Since AS 12.0
    public static final String SYNC_SEARCH_FREETEXT = "Search:FreeText"; // Since AS 12.0
    public static final String SYNC_SEARCH_DEEPTRAVERSAL = "Search:DeepTraversal"; // Since AS 12.0
    public static final String SYNC_SEARCH_LONGID = "Search:LongId"; // Since AS 12.0
    public static final String SYNC_SEARCH_REBUILDRESULTS = "Search:RebuildResults"; // Since AS 12.0
    public static final String SYNC_SEARCH_LESSTHAN = "Search:LessThan"; // Since AS 12.0
    public static final String SYNC_SEARCH_GREATERTHAN = "Search:GreaterThan"; // Since AS 12.0
    public static final String SYNC_SEARCH_SCHEMA = "Search:Schema"; // Since AS 12.0
    public static final String SYNC_SEARCH_SUPPORTED = "Search:Supported"; // Since AS 12.0
    public static final String SYNC_SEARCH_USERNAME = "Search:UserName"; // Since 12.1
    public static final String SYNC_SEARCH_PASSWORD = "Search:Password"; // Since 12.1
    public static final String SYNC_SEARCH_CONVERSATIONID = "Search:ConversationId"; // Since 14.0
    public static final String SYNC_SEARCH_PICTURE = "Search:Picture"; // Since 14.1
    public static final String SYNC_SEARCH_MAXSIZE = "Search:MaxSize"; // Since 14.1
    public static final String SYNC_SEARCH_MAXPICTURES = "Search:MaxPictures"; // Since 14.1

    // Code Page 16: GAL, all AS versions
    public static final String SYNC_GAL_DISPLAYNAME = "GAL:DisplayName";
    public static final String SYNC_GAL_PHONE = "GAL:Phone";
    public static final String SYNC_GAL_OFFICE = "GAL:Office";
    public static final String SYNC_GAL_TITLE = "GAL:Title";
    public static final String SYNC_GAL_COMPANY = "GAL:Company";
    public static final String SYNC_GAL_ALIAS = "GAL:Alias";
    public static final String SYNC_GAL_FIRSTNAME = "GAL:FirstName";
    public static final String SYNC_GAL_LASTNAME = "GAL:LastName";
    public static final String SYNC_GAL_HOMEPHONE = "GAL:HomePhone";
    public static final String SYNC_GAL_MOBILEPHONE = "GAL:MobilePhone";
    public static final String SYNC_GAL_EMAILADDRESS = "GAL:EmailAddress";
    public static final String SYNC_GAL_PICTURE = "GAL:Picture"; // Since 14.1
    public static final String SYNC_GAL_STATUS = "GAL:Status"; // Since 14.1
    public static final String SYNC_GAL_DATA = "GAL:Data"; // Since 14.1

    // Code Page 17: AirSyncBase, Since 12.0
    public static final String SYNC_AIRSYNCBASE_BODYPREFERENCE = "AirSyncBase:BodyPreference";
    public static final String SYNC_AIRSYNCBASE_TYPE = "AirSyncBase:Type";
    public static final String SYNC_AIRSYNCBASE_TRUNCATIONSIZE = "AirSyncBase:TruncationSize";
    public static final String SYNC_AIRSYNCBASE_ALLORNONE = "AirSyncBase:AllOrNone";
    public static final String SYNC_AIRSYNCBASE_BODY = "AirSyncBase:Body";
    public static final String SYNC_AIRSYNCBASE_DATA = "AirSyncBase:Data";
    public static final String SYNC_AIRSYNCBASE_ESTIMATEDDATASIZE = "AirSyncBase:EstimatedDataSize";
    public static final String SYNC_AIRSYNCBASE_TRUNCATED = "AirSyncBase:Truncated";
    public static final String SYNC_AIRSYNCBASE_ATTACHMENTS = "AirSyncBase:Attachments";
    public static final String SYNC_AIRSYNCBASE_ATTACHMENT = "AirSyncBase:Attachment";
    public static final String SYNC_AIRSYNCBASE_DISPLAYNAME = "AirSyncBase:DisplayName";
    public static final String SYNC_AIRSYNCBASE_FILEREFERENCE = "AirSyncBase:FileReference";
    public static final String SYNC_AIRSYNCBASE_METHOD = "AirSyncBase:Method";
    public static final String SYNC_AIRSYNCBASE_CONTENTID = "AirSyncBase:ContentId";
    public static final String SYNC_AIRSYNCBASE_CONTENTLOCATION = "AirSyncBase:ContentLocation";
    public static final String SYNC_AIRSYNCBASE_ISINLINE = "AirSyncBase:IsInline";
    public static final String SYNC_AIRSYNCBASE_NATIVEBODYTYPE = "AirSyncBase:NativeBodyType";
    public static final String SYNC_AIRSYNCBASE_CONTENTTYPE = "AirSyncBase:ContentType";
    public static final String SYNC_AIRSYNCBASE_PREVIEW = "AirSyncBase:Preview"; // Since 14.0
    public static final String SYNC_AIRSYNCBASE_BODYPARTPREFERENCE = "AirSyncBase:BodyPartPreference"; //Since 14.1
    public static final String SYNC_AIRSYNCBASE_BODYPART = "AirSyncBase:BodyPart"; // Since 14.1
    public static final String SYNC_AIRSYNCBASE_STATUS = "AirSyncBase:Status"; //Since 14.1
    public static final String SYNC_AIRSYNCBASE_ADD = "AirSyncBase:Add"; // Since 16.0
    public static final String SYNC_AIRSYNCBASE_DELETE = "AirSyncBase:Delete"; // Since 16.0
    public static final String SYNC_AIRSYNCBASE_CLIENTID = "AirSyncBase:ClientId"; // Since 16.0
    public static final String SYNC_AIRSYNCBASE_CONTENT = "AirSyncBase:Content"; // Since 16.0
    public static final String SYNC_AIRSYNCBASE_LOCATION = "AirSyncBase:Location"; // Since 16.0
    public static final String SYNC_AIRSYNCBASE_ANNOTATION = "AirSyncBase:Annotation"; // Since 16.0
    public static final String SYNC_AIRSYNCBASE_STREET = "AirSyncBase:Street"; // Since 16.0
    public static final String SYNC_AIRSYNCBASE_CITY = "AirSyncBase:City"; // Since 16.0
    public static final String SYNC_AIRSYNCBASE_STATE = "AirSyncBase:State"; // Since 16.0
    public static final String SYNC_AIRSYNCBASE_COUNTRY = "AirSyncBase:Country"; // Since 16.0
    public static final String SYNC_AIRSYNCBASE_POSTALCODE = "AirSyncBase:PostalCode"; // Since 16.0
    public static final String SYNC_AIRSYNCBASE_LATITUDE = "AirSyncBase:Latitude"; // Since 16.0
    public static final String SYNC_AIRSYNCBASE_LONGITUDE = "AirSyncBase:Longitude"; // Since 16.0
    public static final String SYNC_AIRSYNCBASE_ACCURACY = "AirSyncBase:Accuracy"; // Since 16.0
    public static final String SYNC_AIRSYNCBASE_ALTITUDE = "AirSyncBase:Altitude"; // Since 16.0
    public static final String SYNC_AIRSYNCBASE_ALTITUDEACCURACY = "AirSyncBase:AltitudeAccuracy"; // Since 16.0
    public static final String SYNC_AIRSYNCBASE_LOCATIONURI = "AirSyncBase:LocationUri"; // Since 16.0
    public static final String SYNC_AIRSYNCBASE_INSTANCEID = "AirSyncBase:InstanceId"; // Since 16.0
    public static final String SYNC_AIRSYNCBASE_INSTANCEID_DELETE = "AirSyncBase:InstanceId:Delete"; // Internal to transport delete request

    // Code Page 18: Settings, Since 12.0
    public static final String SYNC_SETTINGS_SETTINGS = "Settings:Settings";
    public static final String SYNC_SETTINGS_STATUS = "Settings:Status";
    public static final String SYNC_SETTINGS_GET = "Settings:Get";
    public static final String SYNC_SETTINGS_SET = "Settings:Set";
    public static final String SYNC_SETTINGS_OOF = "Settings:Oof";
    public static final String SYNC_SETTINGS_OOFSTATE = "Settings:OofState";
    public static final String SYNC_SETTINGS_STARTTIME = "Settings:StartTime";
    public static final String SYNC_SETTINGS_ENDTIME = "Settings:EndTime";
    public static final String SYNC_SETTINGS_OOFMESSAGE = "Settings:OofMessage";
    public static final String SYNC_SETTINGS_APPLIESTOINTERVAL = "Settings:AppliesToInternal";
    public static final String SYNC_SETTINGS_APPLIESTOEXTERNALKNOWN = "Settings:AppliesToExternalKnown";
    public static final String SYNC_SETTINGS_APPLIESTOEXTERNALUNKNOWN = "Settings:AppliesToExternalUnknown";
    public static final String SYNC_SETTINGS_ENABLED = "Settings:Enabled";
    public static final String SYNC_SETTINGS_REPLYMESSAGE = "Settings:ReplyMessage";
    public static final String SYNC_SETTINGS_BODYTYPE = "Settings:BodyType";
    public static final String SYNC_SETTINGS_DEVICEPW = "Settings:DevicePassword";
    public static final String SYNC_SETTINGS_PW = "Settings:Password";
    public static final String SYNC_SETTINGS_DEVICEINFORMATION = "Settings:DeviceInformation";
    public static final String SYNC_SETTINGS_MODEL = "Settings:Model";
    public static final String SYNC_SETTINGS_IMEI = "Settings:IMEI";
    public static final String SYNC_SETTINGS_FRIENDLYNAME = "Settings:FriendlyName";
    public static final String SYNC_SETTINGS_OS = "Settings:OS";
    public static final String SYNC_SETTINGS_OSLANGUAGE = "Settings:OSLanguage";
    public static final String SYNC_SETTINGS_PHONENUMBER = "Settings:PhoneNumber";
    public static final String SYNC_SETTINGS_USERINFORMATION = "Settings:UserInformation";
    public static final String SYNC_SETTINGS_EMAILADDRESSES = "Settings:EmailAddresses";
    public static final String SYNC_SETTINGS_SMPTADDRESS = "Settings:SmtpAddress";
    public static final String SYNC_SETTINGS_USERAGENT = "Settings:UserAgent"; // Since 12.1
    public static final String SYNC_SETTINGS_ENABLEOUTBOUNDSMS = "Settings:EnableOutboundSMS"; // Since 14.0
    public static final String SYNC_SETTINGS_MOBILEOPERATOR = "Settings:MobileOperator"; // Since 14.0
    public static final String SYNC_SETTINGS_PRIMARYSMTPADDRESS = "Settings:PrimarySmtpAddress"; // Since 14.1
    public static final String SYNC_SETTINGS_ACCOUNTS = "Settings:Accounts"; // Since 14.1
    public static final String SYNC_SETTINGS_ACCOUNT = "Settings:Account"; // Since 14.1
    public static final String SYNC_SETTINGS_ACCOUNTID = "Settings:AccountId"; // Since 14.1
    public static final String SYNC_SETTINGS_ACCOUNTNAME = "Settings:AccountName"; // Since 14.1
    public static final String SYNC_SETTINGS_USERDISPLAYNAME = "Settings:UserDisplayName"; // Since 14.1
    public static final String SYNC_SETTINGS_SENDDISABLED = "Settings:SendDisabled"; // Since 14.1
    public static final String SYNC_SETTINGS_RIGHTSMANAGEMENTINFORMATION = "Settings:RightsManagementInformation"; // Since 14.1
    // only for internal use - never to be streamed to the mobile
    public static final String SYNC_SETTINGS_PROP_STATUS = "Settings:PropertyStatus";

    //Code Page 19: DocumentLibrary, Since 12.0
    public static final String SYNC_DOCUMENTLIBRARY_LINKID = "DocumentLibrary:LinkId";
    public static final String SYNC_DOCUMENTLIBRARY_DISPLAYNAME = "DocumentLibrary:DisplayName";
    public static final String SYNC_DOCUMENTLIBRARY_ISFOLDER = "DocumentLibrary:IsFolder";
    public static final String SYNC_DOCUMENTLIBRARY_CREATIONDATE = "DocumentLibrary:CreationDate";
    public static final String SYNC_DOCUMENTLIBRARY_LASTMODIFIEDDATE = "DocumentLibrary:LastModifiedDate";
    public static final String SYNC_DOCUMENTLIBRARY_ISHIDDEN = "DocumentLibrary:IsHidden";
    public static final String SYNC_DOCUMENTLIBRARY_CONTENTLENGTH = "DocumentLibrary:ContentLength";
    public static final String SYNC_DOCUMENTLIBRARY_CONTENTTYPE = "DocumentLibrary:ContentType";

    //Code Page 20: ItemOperations, Since 12.0
    public static final String SYNC_ITEMOPERATIONS_ITEMOPERATIONS = "ItemOperations:ItemOperations";
    public static final String SYNC_ITEMOPERATIONS_FETCH = "ItemOperations:Fetch";
    public static final String SYNC_ITEMOPERATIONS_STORE = "ItemOperations:Store";
    public static final String SYNC_ITEMOPERATIONS_OPTIONS = "ItemOperations:Options";
    public static final String SYNC_ITEMOPERATIONS_RANGE = "ItemOperations:Range";
    public static final String SYNC_ITEMOPERATIONS_TOTAL = "ItemOperations:Total";
    public static final String SYNC_ITEMOPERATIONS_PROPERTIES = "ItemOperations:Properties";
    public static final String SYNC_ITEMOPERATIONS_DATA = "ItemOperations:Data";
    public static final String SYNC_ITEMOPERATIONS_STATUS = "ItemOperations:Status";
    public static final String SYNC_ITEMOPERATIONS_RESPONSE = "ItemOperations:Response";
    public static final String SYNC_ITEMOPERATIONS_VERSIONS = "ItemOperations:Version";
    public static final String SYNC_ITEMOPERATIONS_SCHEMA = "ItemOperations:Schema";
    public static final String SYNC_ITEMOPERATIONS_PART = "ItemOperations:Part";
    public static final String SYNC_ITEMOPERATIONS_EMPTYFOLDERCONTENTS = "ItemOperations:EmptyFolderContents";
    public static final String SYNC_ITEMOPERATIONS_DELETESUBFOLDERS = "ItemOperations:DeleteSubFolders";
    public static final String SYNC_ITEMOPERATIONS_USERNAME = "ItemOperations:UserName"; // Since 12.1
    public static final String SYNC_ITEMOPERATIONS_PASSWORD = "ItemOperations:Password"; // Since 12.1
    public static final String SYNC_ITEMOPERATIONS_MOVE = "ItemOperations:Move"; // Since 14.0
    public static final String SYNC_ITEMOPERATIONS_DSTFLDID = "ItemOperations:DstFldId"; // Since 14.0
    public static final String SYNC_ITEMOPERATIONS_CONVERSATIONID = "ItemOperations:ConversationId"; // Since 14.0
    public static final String SYNC_ITEMOPERATIONS_MOVEALWAYS = "ItemOperations:MoveAlways"; // Since 14.0

    // Code Page 21: ComposeMail, Since 14.0
    public static final String SYNC_COMPOSEMAIL_SENDMAIL = "ComposeMail:SendMail";
    public static final String SYNC_COMPOSEMAIL_SMARTFORWARD = "ComposeMail:SmartForward";
    public static final String SYNC_COMPOSEMAIL_SMARTREPLY = "ComposeMail:SmartReply";
    public static final String SYNC_COMPOSEMAIL_SAVEINSENTITEMS = "ComposeMail:SaveInSentItems";
    public static final String SYNC_COMPOSEMAIL_REPLACEMIME = "ComposeMail:ReplaceMime";
    public static final String SYNC_COMPOSEMAIL_TYPE = "ComposeMail:Type"; // not used
    public static final String SYNC_COMPOSEMAIL_SOURCE = "ComposeMail:Source";
    public static final String SYNC_COMPOSEMAIL_FOLDERID = "ComposeMail:FolderId";
    public static final String SYNC_COMPOSEMAIL_ITEMID = "ComposeMail:ItemId";
    public static final String SYNC_COMPOSEMAIL_LONGID = "ComposeMail:LongId";
    public static final String SYNC_COMPOSEMAIL_INSTANCEID = "ComposeMail:InstanceId";
    public static final String SYNC_COMPOSEMAIL_MIME = "ComposeMail:MIME";
    public static final String SYNC_COMPOSEMAIL_CLIENTID = "ComposeMail:ClientId";
    public static final String SYNC_COMPOSEMAIL_STATUS = "ComposeMail:Status";
    public static final String SYNC_COMPOSEMAIL_ACCOUNTID = "ComposeMail:AccountId"; // Since 14.1
    public static final String SYNC_COMPOSEMAIL_FORWARDEES = "ComposeMail:Forwardees"; // Since 16.0
    public static final String SYNC_COMPOSEMAIL_FORWARDEE = "ComposeMail:Forwardee"; // Since 16.0
    public static final String SYNC_COMPOSEMAIL_NAME = "ComposeMail:Name"; // Since 16.0
    public static final String SYNC_COMPOSEMAIL_EMAIL = "ComposeMail:Email"; // Since 16.0
    // only for internal use - never to be streamed to the mobile
    public static final String SYNC_COMPOSEMAIL_REPLYFLAG = "ComposeMail:ReplyFlag";
    public static final String SYNC_COMPOSEMAIL_FORWARDFLAG = "ComposeMail:ForwardFlag";

    // Code Page 22: Email2 - POOMMAIL2, Since 14.0
    public static final String SYNC_POOMMAIL2_UMCALLERID = "POOMMAIL2:UmCallerId";
    public static final String SYNC_POOMMAIL2_UMUSERNOTES = "POOMMAIL2:UmUserNotes";
    public static final String SYNC_POOMMAIL2_UMATTDURATION = "POOMMAIL2:UmAttDuration";
    public static final String SYNC_POOMMAIL2_UMATTORDER = "POOMMAIL2:UmAttOrder";
    public static final String SYNC_POOMMAIL2_CONVERSATIONID = "POOMMAIL2:ConversationId";
    public static final String SYNC_POOMMAIL2_CONVERSATIONINDEX = "POOMMAIL2:ConversationIndex";
    public static final String SYNC_POOMMAIL2_LASTVERBEXECUTED = "POOMMAIL2:LastVerbExecuted";
    public static final String SYNC_POOMMAIL2_LASTVERBEXECUTIONTIME = "POOMMAIL2:LastVerbExecutionTime";
    public static final String SYNC_POOMMAIL2_RECEIVEDASBCC = "POOMMAIL2:ReceivedAsBcc";
    public static final String SYNC_POOMMAIL2_SENDER = "POOMMAIL2:Sender";
    public static final String SYNC_POOMMAIL2_CALENDARTYPE = "POOMMAIL2:CalendarType";
    public static final String SYNC_POOMMAIL2_ISLEAPMONTH = "POOMMAIL2:IsLeapMonth";
    public static final String SYNC_POOMMAIL2_ACCOUNTID = "POOMMAIL2:AccountId"; // Since 14.1
    public static final String SYNC_POOMMAIL2_FIRSTDAYOFWEEK = "POOMMAIL2:FirstDayOfWeek"; // Since 14.1
    public static final String SYNC_POOMMAIL2_MEETINGMESSAGETYPE = "POOMMAIL2:MeetingMessageType"; // Since 14.1
    public static final String SYNC_POOMMAIL2_ISDRAFT = "POOMMAIL2:IsDraft"; // Since 16.0
    public static final String SYNC_POOMMAIL2_BCC = "POOMMAIL2:Bcc"; // Since 16.0
    public static final String SYNC_POOMMAIL2_SEND = "POOMMAIL2:Send"; // Since 16.0

    // Code Page 23: Notes, Since 14.0
    public static final String SYNC_NOTES_SUBJECT = "Notes:Subject";
    public static final String SYNC_NOTES_MESSAGECLASS = "Notes:MessageClass";
    public static final String SYNC_NOTES_LASTMODIFIEDDATE = "Notes:LastModifiedDate";
    public static final String SYNC_NOTES_CATEGORIES = "Notes:Categories";
    public static final String SYNC_NOTES_CATEGORY = "Notes:Category";
    // only for internal use - never to be streamed to the mobile
    public static final String SYNC_NOTES_IGNORE_COLOR = "Notes:IgnoreColor";

    // Code Page 24: RightsManagement, Since 14.1
    public static final String SYNC_RIGHTSMANAGEMENT_SUPPORT = "RightsManagement:RightsManagementSupport";
    public static final String SYNC_RIGHTSMANAGEMENT_TEMPLATES = "RightsManagement:RightsManagementTemplates";
    public static final String SYNC_RIGHTSMANAGEMENT_TEMPLATE = "RightsManagement:RightsManagementTemplate";
    public static final String SYNC_RIGHTSMANAGEMENT_LICENSE = "RightsManagement:RightsManagementLicense";
    public static final String SYNC_RIGHTSMANAGEMENT_EDITALLOWED = "RightsManagement:EditAllowed";
    public static final String SYNC_RIGHTSMANAGEMENT_REPLYALLOWED = "RightsManagement:ReplyAllowed";
    public static final String SYNC_RIGHTSMANAGEMENT_REPLYALLALLOWED = "RightsManagement:ReplyAllAllowed";
    public static final String SYNC_RIGHTSMANAGEMENT_FORWARDALLOWED = "RightsManagement:ForwardAllowed";
    public static final String SYNC_RIGHTSMANAGEMENT_MODIFYRECIPIENTSALLOWED = "RightsManagement:ModifyRecipientsAllowed";
    public static final String SYNC_RIGHTSMANAGEMENT_EXTRACTALLOWED = "RightsManagement:ExtractAllowed";
    public static final String SYNC_RIGHTSMANAGEMENT_PRINTALLOWED = "RightsManagement:PrintAllowed";
    public static final String SYNC_RIGHTSMANAGEMENT_EXPORTALLOWED = "RightsManagement:ExportAllowed";
    public static final String SYNC_RIGHTSMANAGEMENT_PROGRAMMATICACCESSALLOWED = "RightsManagement:ProgrammaticAccessAllowed";
    public static final String SYNC_RIGHTSMANAGEMENT_OWNER = "RightsManagement:Owner";
    public static final String SYNC_RIGHTSMANAGEMENT_CONTENTEXPIRYDATE = "RightsManagement:ContentExpiryDate";
    public static final String SYNC_RIGHTSMANAGEMENT_TEMPLATEID = "RightsManagement:TemplateID";
    public static final String SYNC_RIGHTSMANAGEMENT_TEMPLATENAME = "RightsManagement:TemplateName";
    public static final String SYNC_RIGHTSMANAGEMENT_TEMPLATEDESCRIPTION = "RightsManagement:TemplateDescription";
    public static final String SYNC_RIGHTSMANAGEMENT_CONTENTOWNER = "RightsManagement:ContentOwner";
    public static final String SYNC_RIGHTSMANAGEMENT_REMOVERIGHTSMGNTPROTECTION = "RightsManagement:RemoveRightsManagementProtection";

    // Code page 25: Find, Since 16.1
    public static final String SYNC_FIND_FIND = "Find:Find";
    public static final String SYNC_FIND_SEARCHID = "Find:SearchId";
    public static final String SYNC_FIND_EXECUTESEARCH = "Find:ExecuteSearch";
    public static final String SYNC_FIND_MAILBOXSEARCHCRITERION = "Find:MailBoxSearchCriterion";
    public static final String SYNC_FIND_QUERY = "Find:Query";
    public static final String SYNC_FIND_STATUS = "Find:Status";
    public static final String SYNC_FIND_FREETEXT = "Find:FreeText";
    public static final String SYNC_FIND_OPTIONS = "Find:Options";
    public static final String SYNC_FIND_RANGE = "Find:Range";
    public static final String SYNC_FIND_DEEPTRAVERSAL = "Find:DeepTraversal";
    public static final String SYNC_FIND_RESPONSE = "Find:Response";
    public static final String SYNC_FIND_RESULT = "Find:Result";
    public static final String SYNC_FIND_PROPERTIES = "Find:Properties";
    public static final String SYNC_FIND_PREVIEW = "Find:Preview";
    public static final String SYNC_FIND_HASATTACHMENTS = "Find:HasAttachments";
    public static final String SYNC_FIND_TOTAL = "Find:Total";
    public static final String SYNC_FIND_DISPLAYCC = "Find:DisplayCc";
    public static final String SYNC_FIND_DISPLAYBCC = "Find:DisplayBcc";
    public static final String SYNC_FIND_GALSEARCHCRITERION = "Find:GalSearchCriterion";
    public static final String SYNC_FIND_MAXPICTURES = "Find:MaxPictures";
    public static final String SYNC_FIND_MAXSIZE = "Find:MaxSize";
    public static final String SYNC_FIND_PICTURE = "Find:Picture";

    // Other constants
    public static final int SYNC_FOLDER_TYPE_OTHER = 1;
    public static final int SYNC_FOLDER_TYPE_INBOX = 2;
    public static final int SYNC_FOLDER_TYPE_DRAFTS = 3;
    public static final int SYNC_FOLDER_TYPE_WASTEBASKET = 4;
    public static final int SYNC_FOLDER_TYPE_SENTMAIL = 5;
    public static final int SYNC_FOLDER_TYPE_OUTBOX = 6;
    public static final int SYNC_FOLDER_TYPE_TASK = 7;
    public static final int SYNC_FOLDER_TYPE_APPOINTMENT = 8;
    public static final int SYNC_FOLDER_TYPE_CONTACT = 9;
    public static final int SYNC_FOLDER_TYPE_NOTE = 10;
    public static final int SYNC_FOLDER_TYPE_JOURNAL = 11;
    public static final int SYNC_FOLDER_TYPE_USER_MAIL = 12;
    public static final int SYNC_FOLDER_TYPE_USER_APPOINTMENT = 13;
    public static final int SYNC_FOLDER_TYPE_USER_CONTACT = 14;
    public static final int SYNC_FOLDER_TYPE_USER_TASK = 15;
    public static final int SYNC_FOLDER_TYPE_USER_JOURNAL = 16;
    public static final int SYNC_FOLDER_TYPE_USER_NOTE = 17;
    public static final int SYNC_FOLDER_TYPE_UNKNOWN = 18;
    public static final int SYNC_FOLDER_TYPE_RECIPIENT_CACHE = 19;
    public static final int SYNC_FOLDER_TYPE_DUMMY = 999999;

    public static final int SYNC_CONFLICT_OVERWRITE_SERVER = 0;
    public static final int SYNC_CONFLICT_OVERWRITE_PIM = 1;

    public static final int SYNC_FILTERTYPE_ALL = 0;
    public static final int SYNC_FILTERTYPE_1DAY = 1;
    public static final int SYNC_FILTERTYPE_3DAYS = 2;
    public static final int SYNC_FILTERTYPE_1WEEK = 3;
    public static final int SYNC_FILTERTYPE_2WEEKS = 4;
    public static final int SYNC_FILTERTYPE_1MONTH = 5;
    public static final int SYNC_FILTERTYPE_3MONTHS = 6;
    public static final int SYNC_FILTERTYPE_6MONTHS = 7;
    public static final int SYNC_FILTERTYPE_INCOMPLETETASKS = 8;
    public static final int SYNC_FILTERTYPE_1YEAR = 101;
    public static final int MAX_CUSTOM_FILTERTYPE = 102;
    public static final int SYNC_FILTERTYPE_DISABLE = 999; // AS 16 Drafts

    public static final int SYNC_TRUNCATION_HEADERS = 0;
    public static final int SYNC_TRUNCATION_512B = 1;
    public static final int SYNC_TRUNCATION_1K = 2;
    public static final int SYNC_TRUNCATION_2K = 3;
    public static final int SYNC_TRUNCATION_5K = 4;
    public static final int SYNC_TRUNCATION_10K = 5;
    public static final int SYNC_TRUNCATION_20K = 6;
    public static final int SYNC_TRUNCATION_50K = 7;
    public static final int SYNC_TRUNCATION_100K = 8;
    public static final int SYNC_TRUNCATION_ALL = 9;

    public static final int SYNC_PROVISION_STATUS_SUCCESS = 1;
    public static final int SYNC_PROVISION_STATUS_PROTERROR = 2;
    public static final int SYNC_PROVISION_STATUS_SERVERERROR = 3;
    public static final int SYNC_PROVISION_STATUS_DEVEXTMANAGED = 4;

    public static final int SYNC_PROVISION_POLICYSTATUS_SUCCESS = 1;
    public static final int SYNC_PROVISION_POLICYSTATUS_NOPOLICY = 2;
    public static final int SYNC_PROVISION_POLICYSTATUS_UNKNOWNVALUE = 3;
    public static final int SYNC_PROVISION_POLICYSTATUS_CORRUPTED = 4;
    public static final int SYNC_PROVISION_POLICYSTATUS_POLKEYMISM = 5;

    public static final int SYNC_PROVISION_RWSTATUS_NA = 0;
    public static final int SYNC_PROVISION_RWSTATUS_OK = 1;
    public static final int SYNC_PROVISION_RWSTATUS_PENDING = 2;
    public static final int SYNC_PROVISION_RWSTATUS_REQUESTED = 4;
    public static final int SYNC_PROVISION_RWSTATUS_WIPED = 8;
    public static final int SYNC_PROVISION_RWSTATUS_PENDING_ACCOUNT_ONLY = 16;
    public static final int SYNC_PROVISION_RWSTATUS_REQUESTED_ACCOUNT_ONLY = 32;
    public static final int SYNC_PROVISION_RWSTATUS_WIPED_ACCOUNT_ONLY = 64;

    public static final int SYNC_STATUS_SUCCESS = 1;
    public static final int SYNC_STATUS_INVALIDSYNCKEY = 3;
    public static final int SYNC_STATUS_PROTOCOLLERROR = 4;
    public static final int SYNC_STATUS_SERVERERROR = 5;
    public static final int SYNC_STATUS_CLIENTSERVERCONVERSATIONERROR = 6;
    public static final int SYNC_STATUS_CONFLICTCLIENTSERVEROBJECT = 7;
    public static final int SYNC_STATUS_OBJECTNOTFOUND = 8;
    public static final int SYNC_STATUS_SYNCCANNOTBECOMPLETED = 9;
    public static final int SYNC_STATUS_FOLDERHIERARCHYCHANGED = 12;
    public static final int SYNC_STATUS_SYNCREQUESTINCOMPLETE = 13;
    public static final int SYNC_STATUS_INVALIDWAITORHBVALUE = 14;
    public static final int SYNC_STATUS_SYNCREQUESTINVALID = 15;
    public static final int SYNC_STATUS_RETRY = 16;

    public static final int SYNC_FSSTATUS_SUCCESS = 1;
    public static final int SYNC_FSSTATUS_FOLDEREXISTS = 2;
    public static final int SYNC_FSSTATUS_SYSTEMFOLDER = 3;
    public static final int SYNC_FSSTATUS_FOLDERDOESNOTEXIST = 4;
    public static final int SYNC_FSSTATUS_PARENTNOTFOUND = 5;
    public static final int SYNC_FSSTATUS_SERVERERROR = 6;
    public static final int SYNC_FSSTATUS_REQUESTTIMEOUT = 8;
    public static final int SYNC_FSSTATUS_SYNCKEYERROR = 9;
    public static final int SYNC_FSSTATUS_MAILFORMEDREQ = 10;
    public static final int SYNC_FSSTATUS_UNKNOWNERROR = 11;
    public static final int SYNC_FSSTATUS_CODEUNKNOWN = 12;

    public static final int SYNC_GETITEMESTSTATUS_SUCCESS = 1;
    public static final int SYNC_GETITEMESTSTATUS_COLLECTIONINVALID = 2;
    public static final int SYNC_GETITEMESTSTATUS_SYNCSTATENOTPRIMED = 3;
    public static final int SYNC_GETITEMESTSTATUS_SYNCKKEYINVALID = 4;

    public static final int SYNC_ITEMOPERATIONSSTATUS_SUCCESS = 1;
    public static final int SYNC_ITEMOPERATIONSSTATUS_PROTERROR = 2;
    public static final int SYNC_ITEMOPERATIONSSTATUS_SERVERERROR = 3;
    public static final int SYNC_ITEMOPERATIONSSTATUS_DL_BADURI = 4;
    public static final int SYNC_ITEMOPERATIONSSTATUS_DL_ACCESSDENIED = 5;
    public static final int SYNC_ITEMOPERATIONSSTATUS_DL_NOTFOUND = 6;
    public static final int SYNC_ITEMOPERATIONSSTATUS_DL_CONNFAILED = 7;
    public static final int SYNC_ITEMOPERATIONSSTATUS_DL_BYTERANGEINVALID = 8;
    public static final int SYNC_ITEMOPERATIONSSTATUS_DL_STOREUNKNOWN = 9;
    public static final int SYNC_ITEMOPERATIONSSTATUS_DL_EMPTYFILE = 10;
    public static final int SYNC_ITEMOPERATIONSSTATUS_DL_TOOLARGE = 11;
    public static final int SYNC_ITEMOPERATIONSSTATUS_DL_IOFAILURE = 12;
    public static final int SYNC_ITEMOPERATIONSSTATUS_CONVERSIONFAILED = 14;
    public static final int SYNC_ITEMOPERATIONSSTATUS_INVALIDATT = 15;
    public static final int SYNC_ITEMOPERATIONSSTATUS_BLOCKED = 16;
    public static final int SYNC_ITEMOPERATIONSSTATUS_EMPTYFOLDER = 17;
    public static final int SYNC_ITEMOPERATIONSSTATUS_CREDSREQUIRED = 18;
    public static final int SYNC_ITEMOPERATIONSSTATUS_PROTOCOLERROR = 155;
    public static final int SYNC_ITEMOPERATIONSSTATUS_UNSUPPORTEDACTION = 156;

    public static final int SYNC_MEETRESPSTATUS_SUCCESS = 1;
    public static final int SYNC_MEETRESPSTATUS_INVALIDMEETREQ = 2;
    public static final int SYNC_MEETRESPSTATUS_MAILBOXERROR = 3;
    public static final int SYNC_MEETRESPSTATUS_SERVERERROR = 4;

    public static final int SYNC_MOVEITEMSSTATUS_INVALIDSOURCEID = 1;
    public static final int SYNC_MOVEITEMSSTATUS_INVALIDDESTID = 2;
    public static final int SYNC_MOVEITEMSSTATUS_SUCCESS = 3;
    public static final int SYNC_MOVEITEMSSTATUS_SAMESOURCEANDDEST = 4;
    public static final int SYNC_MOVEITEMSSTATUS_CANNOTMOVE = 5;
    public static final int SYNC_MOVEITEMSSTATUS_SOURCEORDESTLOCKED = 7;

    public static final int SYNC_PINGSTATUS_HBEXPIRED = 1;
    public static final int SYNC_PINGSTATUS_CHANGES = 2;
    public static final int SYNC_PINGSTATUS_FAILINGPARAMS = 3;
    public static final int SYNC_PINGSTATUS_SYNTAXERROR = 4;
    public static final int SYNC_PINGSTATUS_HBOUTOFRANGE = 5;
    public static final int SYNC_PINGSTATUS_TOOMUCHFOLDERS = 6;
    public static final int SYNC_PINGSTATUS_FOLDERHIERSYNCREQUIRED = 7;
    public static final int SYNC_PINGSTATUS_SERVERERROR = 8;

    public static final int SYNC_RESOLVERECIPSSTATUS_SUCCESS = 1;
    public static final int SYNC_RESOLVERECIPSSTATUS_PROTOCOLERROR = 5;
    public static final int SYNC_RESOLVERECIPSSTATUS_SERVERERROR = 6;
    public static final int SYNC_RESOLVERECIPSSTATUS_RESPONSE_SUCCESS = 1;
    public static final int SYNC_RESOLVERECIPSSTATUS_RESPONSE_AMBRECIP = 2;
    public static final int SYNC_RESOLVERECIPSSTATUS_RESPONSE_AMBRECIPPARTIAL = 3;
    public static final int SYNC_RESOLVERECIPSSTATUS_RESPONSE_UNRESOLVEDRECIP = 4;
    public static final int SYNC_RESOLVERECIPSSTATUS_CERTIFICATES_SUCCESS = 1;
    public static final int SYNC_RESOLVERECIPSSTATUS_CERTIFICATES_NOVALIDCERT = 7;
    public static final int SYNC_RESOLVERECIPSSTATUS_CERTIFICATES_CERTLIMIT = 8;
    public static final int SYNC_RESOLVERECIPSSTATUS_AVAILABILITY_SUCCESS = 1;
    public static final int SYNC_RESOLVERECIPSSTATUS_AVAILABILITY_MORETHAN100 = 160;
    public static final int SYNC_RESOLVERECIPSSTATUS_AVAILABILITY_MORETHAN20 = 161;
    public static final int SYNC_RESOLVERECIPSSTATUS_AVAILABILITY_REISSUE = 162;
    public static final int SYNC_RESOLVERECIPSSTATUS_AVAILABILITY_FAILED = 163;
    public static final int SYNC_RESOLVERECIPSSTATUS_PICTURE_SUCCESS = 1;
    public static final int SYNC_RESOLVERECIPSSTATUS_PICTURE_NOFOTO = 173;
    public static final int SYNC_RESOLVERECIPSSTATUS_PICTURE_MAXSIZEEXCEEDED = 174;
    public static final int SYNC_RESOLVERECIPSSTATUS_PICTURE_MAXPICTURESEXCEEDED = 175;

    public static final int SYNC_SEARCHSTATUS_SUCCESS = 1;
    public static final int SYNC_SEARCHSTATUS_SERVERERROR = 3;
    public static final int SYNC_SEARCHSTATUS_STORE_SUCCESS = 1;
    public static final int SYNC_SEARCHSTATUS_STORE_REQINVALID = 2;
    public static final int SYNC_SEARCHSTATUS_STORE_SERVERERROR = 3;
    public static final int SYNC_SEARCHSTATUS_STORE_BADLINK = 4;
    public static final int SYNC_SEARCHSTATUS_STORE_ACCESSDENIED = 5;
    public static final int SYNC_SEARCHSTATUS_STORE_NOTFOUND = 6;
    public static final int SYNC_SEARCHSTATUS_STORE_CONNECTIONFAILED = 7;
    public static final int SYNC_SEARCHSTATUS_STORE_TOOCOMPLEX = 8;
    public static final int SYNC_SEARCHSTATUS_STORE_TIMEDOUT = 10;
    public static final int SYNC_SEARCHSTATUS_STORE_FOLDERSYNCREQ = 11;
    public static final int SYNC_SEARCHSTATUS_STORE_ENDOFRETRANGE = 12;
    public static final int SYNC_SEARCHSTATUS_STORE_ACCESSBLOCKED = 13;
    public static final int SYNC_SEARCHSTATUS_STORE_CREDENTIALSREQ = 14;
    public static final int SYNC_SEARCHSTATUS_PICTURE_SUCCESS = 1;
    public static final int SYNC_SEARCHSTATUS_PICTURE_NOFOTO = 173;
    public static final int SYNC_SEARCHSTATUS_PICTURE_MAXSIZEEXCEEDED = 174;
    public static final int SYNC_SEARCHSTATUS_PICTURE_MAXPICTURESEXCEEDED = 175;

    public static final int SYNC_SETTINGSSTATUS_SUCCESS = 1;
    public static final int SYNC_SETTINGSSTATUS_PROTOCOLLERROR = 2;
    public static final int SYNC_SETTINGSSTATUS_DEVINFO_SUCCESS = 1;
    public static final int SYNC_SETTINGSSTATUS_DEVINFO_PROTOCOLLERROR = 2;
    public static final int SYNC_SETTINGSSTATUS_DEVIPASS_SUCCESS = 1;
    public static final int SYNC_SETTINGSSTATUS_DEVIPASS_PROTOCOLLERROR = 2;
    public static final int SYNC_SETTINGSSTATUS_DEVIPASS_INVALIDARGS = 3;
    public static final int SYNC_SETTINGSSTATUS_DEVIPASS_DENIED = 7;
    public static final int SYNC_SETTINGSSTATUS_USERINFO_SUCCESS = 1;
    public static final int SYNC_SETTINGSSTATUS_USERINFO_PROTOCOLLERROR = 2;

    public static final int SYNC_SETTINGSOOF_DISABLED = 0;
    public static final int SYNC_SETTINGSOOF_GLOBAL = 1;
    public static final int SYNC_SETTINGSOOF_TIMEBASED = 2;

    public static final int SYNC_MIMETRUNCATION_ALL = 0;
    public static final int SYNC_MIMETRUNCATION_4096 = 1;
    public static final int SYNC_MIMETRUNCATION_5120 = 2;
    public static final int SYNC_MIMETRUNCATION_7168 = 3;
    public static final int SYNC_MIMETRUNCATION_10240 = 4;
    public static final int SYNC_MIMETRUNCATION_20480 = 5;
    public static final int SYNC_MIMETRUNCATION_51200 = 6;
    public static final int SYNC_MIMETRUNCATION_102400 = 7;
    public static final int SYNC_MIMETRUNCATION_COMPLETE = 8;

    public static final int SYNC_MIMESUPPORT_NEVER = 0;
    public static final int SYNC_MIMESUPPORT_SMIME = 1;
    public static final int SYNC_MIMESUPPORT_ALWAYS = 2;

    public static final int SYNC_VALIDATECERTSTATUS_SUCCESS = 1;
    public static final int SYNC_VALIDATECERTSTATUS_PROTOCOLLERROR = 2;
    public static final int SYNC_VALIDATECERTSTATUS_CANTVALIDATESIG = 3;
    public static final int SYNC_VALIDATECERTSTATUS_DIGIDUNTRUSTED = 4;
    public static final int SYNC_VALIDATECERTSTATUS_CERTCHAINNOTCORRECT = 5;
    public static final int SYNC_VALIDATECERTSTATUS_DIGIDNOTVALIDFORSIGN = 6;
    public static final int SYNC_VALIDATECERTSTATUS_DIGIDNOTVALID = 7;
    public static final int SYNC_VALIDATECERTSTATUS_INVALIDCHAINCERTSTIME = 8;
    public static final int SYNC_VALIDATECERTSTATUS_DIGIDUSEDINCORRECTLY = 9;
    public static final int SYNC_VALIDATECERTSTATUS_INCORRECTDIGIDINFO = 10;
    public static final int SYNC_VALIDATECERTSTATUS_INCORRECTUSEOFDIGIDINCHAIN = 11;
    public static final int SYNC_VALIDATECERTSTATUS_DIGIDDOESNOTMATCHEMAIL = 12;
    public static final int SYNC_VALIDATECERTSTATUS_DIGIDREVOKED = 13;
    public static final int SYNC_VALIDATECERTSTATUS_DIGIDSERVERUNAVAILABLE = 14;
    public static final int SYNC_VALIDATECERTSTATUS_DIGIDINCHAINREVOKED = 15;
    public static final int SYNC_VALIDATECERTSTATUS_DIGIDREVSTATUSUNVALIDATED = 16;
    public static final int SYNC_VALIDATECERTSTATUS_SERVERERROR = 17;

    public static final int SYNC_FINDSTATUS_SUCCESS = 1;
    public static final int SYNC_FINDSTATUS_INVALIDREQUEST = 2;
    public static final int SYNC_FINDSTATUS_FOLDERSYNCREQUIRED = 3;
    public static final int SYNC_FINDSTATUS_STARTRANGEZER0 = 4;

    public static final int SYNC_COMMONSTATUS_SUCCESS = 1;
    public static final int SYNC_COMMONSTATUS_INVALIDCONTENT = 101;
    public static final int SYNC_COMMONSTATUS_INVALIDWBXML = 102;
    public static final int SYNC_COMMONSTATUS_INVALIDXML = 103;
    public static final int SYNC_COMMONSTATUS_INVALIDDATETIME = 104;
    public static final int SYNC_COMMONSTATUS_INVALIDCOMBINATIONOFIDS = 105;
    public static final int SYNC_COMMONSTATUS_INVALIDIDS = 106;
    public static final int SYNC_COMMONSTATUS_INVALIDMIME = 107;
    public static final int SYNC_COMMONSTATUS_DEVIDMISSINGORINVALID = 108;
    public static final int SYNC_COMMONSTATUS_DEVTYPEMISSINGORINVALID = 109;
    public static final int SYNC_COMMONSTATUS_SERVERERROR = 110;
    public static final int SYNC_COMMONSTATUS_SERVERERRORRETRYLATER = 111;
    public static final int SYNC_COMMONSTATUS_ADACCESSDENIED = 112;
    public static final int SYNC_COMMONSTATUS_MAILBOXQUOTAEXCEEDED = 113;
    public static final int SYNC_COMMONSTATUS_MAILBOXSERVEROFFLINE = 114;
    public static final int SYNC_COMMONSTATUS_SENDQUOTAEXCEEDED = 115;
    public static final int SYNC_COMMONSTATUS_MESSRECIPUNRESOLVED = 116;
    public static final int SYNC_COMMONSTATUS_MESSREPLYNOTALLOWED = 117;
    public static final int SYNC_COMMONSTATUS_MESSPREVSENT = 118;
    public static final int SYNC_COMMONSTATUS_MESSHASNORECIP = 119;
    public static final int SYNC_COMMONSTATUS_MAILSUBMISSIONFAILED = 120;
    public static final int SYNC_COMMONSTATUS_MESSREPLYFAILED = 121;
    public static final int SYNC_COMMONSTATUS_ATTTOOLARGE = 122;
    public static final int SYNC_COMMONSTATUS_USERHASNOMAILBOX = 123;
    public static final int SYNC_COMMONSTATUS_USERCANTBEANONYMOUS = 124;
    public static final int SYNC_COMMONSTATUS_USERPRINCIPALNOTFOUND = 125;
    public static final int SYNC_COMMONSTATUS_USERDISABLEDFORSYNC = 126;
    public static final int SYNC_COMMONSTATUS_USERONNEWMAILBOXCANTSYNC = 127;
    public static final int SYNC_COMMONSTATUS_USERONLEGACYMAILBOXCANTSYNC = 128;
    public static final int SYNC_COMMONSTATUS_DEVICEBLOCKEDFORUSER = 129;
    public static final int SYNC_COMMONSTATUS_ACCESSDENIED = 130;
    public static final int SYNC_COMMONSTATUS_ACCOUNTDISABLED = 131;
    public static final int SYNC_COMMONSTATUS_SYNCSTATENOTFOUND = 132;
    public static final int SYNC_COMMONSTATUS_SYNCSTATELOCKED = 133;
    public static final int SYNC_COMMONSTATUS_SYNCSTATECORRUPT = 134;
    public static final int SYNC_COMMONSTATUS_SYNCSTATEEXISTS = 135;
    public static final int SYNC_COMMONSTATUS_SYNCSTATEVERSIONINVALID = 136;
    public static final int SYNC_COMMONSTATUS_COMMANDONOTSUPPORTED = 137;
    public static final int SYNC_COMMONSTATUS_VERSIONNOTSUPPORTED = 138;
    public static final int SYNC_COMMONSTATUS_DEVNOTFULLYPROVISIONABLE = 139;
    public static final int SYNC_COMMONSTATUS_REMWIPEREQUESTED = 140;
    public static final int SYNC_COMMONSTATUS_LEGACYDEVONSTRICTPOLICY = 141;
    public static final int SYNC_COMMONSTATUS_DEVICENOTPROVISIONED = 142;
    public static final int SYNC_COMMONSTATUS_POLICYREFRESH = 143;
    public static final int SYNC_COMMONSTATUS_INVALIDPOLICYKEY = 144;
    public static final int SYNC_COMMONSTATUS_EXTMANDEVICESNOTALLOWED = 145;
    public static final int SYNC_COMMONSTATUS_NORECURRINCAL = 146;
    public static final int SYNC_COMMONSTATUS_UNEXPECTEDITEMCLASS = 147;
    public static final int SYNC_COMMONSTATUS_REMSERVERHASNOSSL = 148;
    public static final int SYNC_COMMONSTATUS_INVALIDSTOREDREQ = 149;
    public static final int SYNC_COMMONSTATUS_ITEMNOTFOUND = 150;
    public static final int SYNC_COMMONSTATUS_TOOMANYFOLDERS = 151;
    public static final int SYNC_COMMONSTATUS_NOFOLDERSFOUND = 152;
    public static final int SYNC_COMMONSTATUS_ITEMLOSTAFTERMOVE = 153;
    public static final int SYNC_COMMONSTATUS_FAILUREINMOVE = 154;
    public static final int SYNC_COMMONSTATUS_NONPERSISTANTMOVEDISALLOWED = 155;
    public static final int SYNC_COMMONSTATUS_MOVEINVALIDDESTFOLDER = 156;
    public static final int SYNC_COMMONSTATUS_INVALIDACCOUNTID = 166;
    public static final int SYNC_COMMONSTATUS_ACCOUNTSENDDISABLED = 167;
    public static final int SYNC_COMMONSTATUS_IRMFEATUREDISABLED = 168;
    public static final int SYNC_COMMONSTATUS_IRMTRANSIENTERROR = 169;
    public static final int SYNC_COMMONSTATUS_IRMPERMANENTERROR = 170;
    public static final int SYNC_COMMONSTATUS_IRMINVALIDTEMPLATEID = 171;
    public static final int SYNC_COMMONSTATUS_IRMOPERATIONNOTPERMITTED = 172;
    public static final int SYNC_COMMONSTATUS_NOPICTURE = 173;
    public static final int SYNC_COMMONSTATUS_PICTURETOOLARGE = 174;
    public static final int SYNC_COMMONSTATUS_PICTURELIMITREACHED = 175;
    public static final int SYNC_COMMONSTATUS_BODYPARTCONVERSATIONTOOLARGE = 176;
    public static final int SYNC_COMMONSTATUS_MAXDEVICESREACHED = 177;

    public static final int HTTP_CODE_200 = 200;
    public static final int HTTP_CODE_400 = 400;
    public static final int HTTP_CODE_401 = 401;
    public static final int HTTP_CODE_449 = 449;
    public static final int HTTP_CODE_500 = 500;
    public static final int HTTP_CODE_503 = 503;

    public static final int WINDOW_SIZE_MAX = 512;

    //logging defs
    public static final int LOGLEVEL_OFF = 0;
    public static final int LOGLEVEL_FATAL = 1;
    public static final int LOGLEVEL_ERROR = 2;
    public static final int LOGLEVEL_WARN = 4;
    public static final int LOGLEVEL_INFO = 8;
    public static final int LOGLEVEL_DEBUG = 16;
    public static final int LOGLEVEL_WBXML = 32;
    public static final int LOGLEVEL_DEVICEID = 64;
    public static final int LOGLEVEL_WBXMLSTACK = 128;

    public static final int LOGLEVEL_ALL = LOGLEVEL_FATAL | LOGLEVEL_ERROR | LOGLEVEL_WARN | LOGLEVEL_INFO | LOGLEVEL_DEBUG | LOGLEVEL_WBXML;

    public static final int BACKEND_DISCARD_DATA = 1;

    public static final int SYNC_BODYPREFERENCE_UNDEFINED = 0;
    public static final int SYNC_BODYPREFERENCE_PLAIN = 1;
    public static final int SYNC_BODYPREFERENCE_HTML = 2;
    public static final int SYNC_BODYPREFERENCE_RTF = 3;
    public static final int SYNC_BODYPREFERENCE_MIME = 4;

    public static final int SYNC_FLAGSTATUS_CLEAR = 0;
    public static final int SYNC_FLAGSTATUS_COMPLETE = 1;
    public static final int SYNC_FLAGSTATUS_ACTIVE = 2;

    public static final String DEFAULT_EMAIL_CONTENTCLASS = "urn:content-classes:message";
    public static final String DEFAULT_CALENDAR_CONTENTCLASS = "urn:content-classes:calendarmessage";

    public static final int SYNC_MAIL_LASTVERB_UNKNOWN = 0;
    public static final int SYNC_MAIL_LASTVERB_REPLYSENDER = 1;
    public static final int SYNC_MAIL_LASTVERB_REPLYALL = 2;
    public static final int SYNC_MAIL_LASTVERB_FORWARD = 3;

    public static final int INTERNET_CPID_WINDOWS1252 = 1252;
    public static final int INTERNET_CPID_UTF8 = 65001;

    public static final int MAPI_E_NOT_ENOUGH_MEMORY_32BIT = -2147024882;
    public static final long MAPI_E_NOT_ENOUGH_MEMORY_64BIT = 2147942414L;

    public static final String SYNC_SETTINGSOOF_BODYTYPE_HTML = "HTML";
    public static final String SYNC_SETTINGSOOF_BODYTYPE_TEXT = "TEXT";

    public static final int SYNC_FILEAS_FIRSTLAST = 1;
    public static final int SYNC_FILEAS_LASTFIRST = 2;
    public static final int SYNC_FILEAS_COMPANYONLY = 3;
    public static final int SYNC_FILEAS_COMPANYLAST = 4;
    public static final int SYNC_FILEAS_COMPANYFIRST = 5;
    public static final int SYNC_FILEAS_LASTCOMPANY = 6;
    public static final int SYNC_FILEAS_FIRSTCOMPANY = 7;

    public static final int SYNC_RESOLVERECIPIENTS_TYPE_GAL = 1;
    public static final int SYNC_RESOLVERECIPIENTS_TYPE_CONTACT = 2;

    public static final int SYNC_RESOLVERECIPIENTS_CERTRETRIEVE_NO = 1;
    public static final int SYNC_RESOLVERECIPIENTS_CERTRETRIEVE_FULL = 2;
    public static final int SYNC_RESOLVERECIPIENTS_CERTRETRIEVE_MINI = 3;

    public static final int NOTEIVERB_REPLYTOSENDER = 102;
    public static final int NOTEIVERB_REPLYTOALL = 103;
    public static final int NOTEIVERB_FORWARD = 104;

    public static final int AS_REPLYTOSENDER = 1;
    public static final int AS_REPLYTOALL = 2;
    public static final int AS_FORWARD = 3;

    public static final int AUTODISCOVER_LOGIN_EMAIL = 0;
    public static final int AUTODISCOVER_LOGIN_NO_DOT = 1;
    public static final int AUTODISCOVER_LOGIN_F_NO_DOT_LAST = 2;
    public static final int AUTODISCOVER_LOGIN_F_DOT_LAST = 3;

}
