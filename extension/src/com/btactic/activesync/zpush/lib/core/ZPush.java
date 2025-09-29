package com.btactic.activesync.zpush.lib.core;

import java.util.*;
import java.util.logging.Logger;

public class ZPush {
    private static final Logger logger = Logger.getLogger(ZPush.class.getName());

    // Constants
    public static final int UNAUTHENTICATED = 1;
    public static final int UNPROVISIONED = 2;
    public static final int NOACTIVESYNCCOMMAND = 3;
    public static final int WEBSERVICECOMMAND = 4;
    public static final int HIERARCHYCOMMAND = 5;
    public static final int PLAININPUT = 6;
    public static final int REQUESTHANDLER = 7;
    public static final int CLASS_NAME = 1;
    public static final int CLASS_REQUIRESPROTOCOLVERSION = 2;
    public static final int CLASS_DEFAULTTYPE = 3;
    public static final int CLASS_OTHERTYPES = 4;

    // AS Versions
    public static final String ASV_1 = "1.0";
    public static final String ASV_2 = "2.0";
    public static final String ASV_21 = "2.1";
    public static final String ASV_25 = "2.5";
    public static final String ASV_12 = "12.0";
    public static final String ASV_121 = "12.1";
    public static final String ASV_14 = "14.0";
    public static final String ASV_141 = "14.1";
    public static final String ASV_16 = "16.0";
    public static final String ASV_161 = "16.1";

    // Command codes
    public static final int COMMAND_SYNC = 0;
    public static final int COMMAND_SENDMAIL = 1;
    public static final int COMMAND_SMARTFORWARD = 2;
    public static final int COMMAND_SMARTREPLY = 3;
    public static final int COMMAND_GETATTACHMENT = 4;
    public static final int COMMAND_FOLDERSYNC = 9;
    public static final int COMMAND_FOLDERCREATE = 10;
    public static final int COMMAND_FOLDERDELETE = 11;
    public static final int COMMAND_FOLDERUPDATE = 12;
    public static final int COMMAND_MOVEITEMS = 13;
    public static final int COMMAND_GETITEMESTIMATE = 14;
    public static final int COMMAND_MEETINGRESPONSE = 15;
    public static final int COMMAND_SEARCH = 16;
    public static final int COMMAND_SETTINGS = 17;
    public static final int COMMAND_PING = 18;
    public static final int COMMAND_ITEMOPERATIONS = 19;
    public static final int COMMAND_PROVISION = 20;
    public static final int COMMAND_RESOLVERECIPIENTS = 21;
    public static final int COMMAND_VALIDATECERT = 22;
    public static final int COMMAND_FIND = 23;

    // Deprecated
    public static final int COMMAND_GETHIERARCHY = -1;
    public static final int COMMAND_CREATECOLLECTION = -2;
    public static final int COMMAND_DELETECOLLECTION = -3;
    public static final int COMMAND_MOVECOLLECTION = -4;
    public static final int COMMAND_NOTIFY = -5;

    // Webservice
    public static final int COMMAND_WEBSERVICE_DEVICE = -100;
    public static final int COMMAND_WEBSERVICE_USERS = -101;
    public static final int COMMAND_WEBSERVICE_INFO = -102;

    // Latest supported state version (stub)
    public static final int STATE_VERSION = 2;

    // Static fields
    private static List<String> autoloadBackendPreference = Arrays.asList(
            "BackendKopano", "BackendCombined", "BackendIMAP", "BackendVCardDir", "BackendMaildir"
    );

    private static List<String> supportedASVersions = Arrays.asList(
            ASV_12, ASV_121, ASV_14, ASV_141, ASV_16, ASV_161
    );

    private static Map<Integer, Map<Integer, Object>> supportedCommands = new HashMap<>();
    private static Map<String, Map<Integer, Object>> classes = new HashMap<>();

    private static IStateMachine stateMachine;
    private static ISearchProvider searchProvider;
    private static DeviceManager deviceManager;
    private static TopCollector topCollector;
    private static IBackend backend;
    private static Map<String, SyncFolder> addSyncFolders;
    private static Map<String, Object> policies;

    static {
        // Initialize supportedCommands (example for COMMAND_SYNC)
        Map<Integer, Object> syncCmd = new HashMap<>();
        syncCmd.put(REQUESTHANDLER, "Sync");
        supportedCommands.put(COMMAND_SYNC, syncCmd);

        // Initialize classes (example for Email)
        Map<Integer, Object> emailClass = new HashMap<>();
        emailClass.put(CLASS_NAME, "SyncMail");
        emailClass.put(CLASS_REQUIRESPROTOCOLVERSION, false);
        emailClass.put(CLASS_DEFAULTTYPE, "Inbox");
        emailClass.put(CLASS_OTHERTYPES, Arrays.asList("Other", "Drafts", "SentMail"));
        classes.put("Email", emailClass);
    }

    // Example of a method
    public static IStateMachine getStateMachine() throws FatalNotImplementedException, ServiceUnavailableException {
        if (stateMachine == null) {
            IStateMachine backendStateMachine = getBackend().getStateMachine();
            if (backendStateMachine != null) {
                stateMachine = backendStateMachine;
            } else {
                stateMachine = new FileStateMachine();
            }

            if (stateMachine.getStateVersion() != getLatestStateVersion()) {
                if (TopCollector.exists()) getTopCollector().announceInformation("Run migration script!", true);
                throw new ServiceUnavailableException("The state version is not the latest version.");
            }
        }
        return stateMachine;
    }

    public static int getLatestStateVersion() {
        return STATE_VERSION;
    }

    // Placeholder for getBackend()
    public static IBackend getBackend() throws FatalMisconfigurationException {
        if (backend == null) {
            // logic to load backend dynamically
        }
        return backend;
    }

// Exceptions
class FatalMisconfigurationException extends Exception {
    public FatalMisconfigurationException(String message) { super(message); }
}

class FatalNotImplementedException extends Exception {
    public FatalNotImplementedException(String message) { super(message); }
}

class ServiceUnavailableException extends Exception {
    public ServiceUnavailableException(String message) { super(message); }
}

// Interfaces (stubs for backend/state management)
interface IStateMachine {
    int getStateVersion();
}

interface ISearchProvider {}
interface IBackend {
    IStateMachine getStateMachine();
}
interface DeviceManager {}
interface TopCollector {
    static boolean exists() { return false; }
    void announceInformation(String message, boolean urgent);
}
class FileStateMachine implements IStateMachine {
    public int getStateVersion() { return ZPush.STATE_VERSION; }
}

    // Configuration check
    public static void checkConfig() throws FatalMisconfigurationException {
        if (getBackend() == null) {
            throw new FatalMisconfigurationException("No backend configured.");
        }
        if (supportedASVersions.isEmpty()) {
            throw new FatalMisconfigurationException("Supported AS Versions not configured.");
        }
    }

    // Device manager getter
    public static DeviceManager getDeviceManager() throws FatalMisconfigurationException {
        if (deviceManager == null) {
            deviceManager = new DeviceManager() {
                // Implement methods as needed
            };
        }
        return deviceManager;
    }

    // TopCollector getter
    public static TopCollector getTopCollector() throws FatalMisconfigurationException {
        if (topCollector == null) {
            topCollector = new TopCollector() {
                public void announceInformation(String message, boolean urgent) {
                    logger.info("[TopCollector] " + message + " Urgent: " + urgent);
                }
            };
        }
        return topCollector;
    }

    // Additional Sync Folders getter
    public static Map<String, SyncFolder> getAdditionalSyncFolders() {
        if (addSyncFolders == null) {
            addSyncFolders = new HashMap<>();
            // Could load from config
        }
        return addSyncFolders;
    }

    // Request handler lookup
    public static String getRequestHandlerForCommand(int commandCode) {
        Map<Integer, Object> cmd = supportedCommands.get(commandCode);
        if (cmd != null && cmd.containsKey(REQUESTHANDLER)) {
            return (String) cmd.get(REQUESTHANDLER);
        }
        return null;
    }

    // Backend dynamic initialization
    public static IBackend getBackend() throws FatalMisconfigurationException {
        if (backend == null) {
            for (String className : autoloadBackendPreference) {
                try {
                    Class<?> clazz = Class.forName("com.example.zpush.backend." + className);
                    Object instance = clazz.getDeclaredConstructor().newInstance();
                    if (instance instanceof IBackend) {
                        backend = (IBackend) instance;
                        logger.info("Loaded backend: " + className);
                        break;
                    }
                } catch (ClassNotFoundException e) {
                    logger.warning("Backend class not found: " + className);
                } catch (Exception e) {
                    throw new FatalMisconfigurationException("Failed to initialize backend: " + e.getMessage());
                }
            }

            if (backend == null) {
                throw new FatalMisconfigurationException("No suitable backend found.");
            }
        }
        return backend;
    }

    // Advanced configuration checks
    public static void checkAdvancedConfig() throws FatalMisconfigurationException {
        if (specialLogUsers == null) {
            throw new FatalMisconfigurationException("The WBXML log users is not initialized.");
        }

        if (SYNC_CONTACTS_MAXPICTURESIZE <= 0) {
            throw new FatalMisconfigurationException("SYNC_CONTACTS_MAXPICTURESIZE must be > 0");
        }

        if (PING_LOWER_BOUND_LIFETIME != -1 &&
            (PING_LOWER_BOUND_LIFETIME < 1 || PING_LOWER_BOUND_LIFETIME > 3540)) {
            throw new FatalMisconfigurationException("PING_LOWER_BOUND_LIFETIME must be 1-3540 or -1 (false)");
        }

        if (PING_HIGHER_BOUND_LIFETIME != -1 &&
            (PING_HIGHER_BOUND_LIFETIME < 1 || PING_HIGHER_BOUND_LIFETIME > 3540)) {
            throw new FatalMisconfigurationException("PING_HIGHER_BOUND_LIFETIME must be 1-3540 or -1 (false)");
        }

        if (PING_HIGHER_BOUND_LIFETIME != -1 && PING_LOWER_BOUND_LIFETIME != -1 &&
            PING_HIGHER_BOUND_LIFETIME < PING_LOWER_BOUND_LIFETIME) {
            throw new FatalMisconfigurationException("PING_HIGHER_BOUND_LIFETIME must be >= PING_LOWER_BOUND_LIFETIME");
        }

        if (RETRY_AFTER_DELAY != -1 && RETRY_AFTER_DELAY < 1) {
            throw new FatalMisconfigurationException("RETRY_AFTER_DELAY must be > 0 or -1 (false)");
        }

        // Check additional folders configuration
        if (additionalFolders != null) {
            for (Map<String, Object> af : additionalFolders) {
                if (!af.containsKey("store") || !af.containsKey("folderid") ||
                    !af.containsKey("name") || !af.containsKey("type")) {
                    logger.warning("Additional folder is missing required parameters. Skipping.");
                    continue;
                }
            }
        }

        // Initialize state machine, which also initializes backend
        getStateMachine();
    }

    // Returns the StateMachine object (lazy initialization)
    public static IStateMachine getStateMachine() throws FatalNotImplementedException, ServiceUnavailableException, FatalMisconfigurationException {
        if (stateMachine == null) {
            IBackend backendInstance = getBackend();
            IStateMachine backendSM = backendInstance.getStateMachine();

            if (backendSM != null) {
                stateMachine = backendSM;
            } else {
                // Default state machine (File or SQL)
                if ("SQL".equals(STATE_MACHINE)) {
                    stateMachine = new SqlStateMachine();
                } else {
                    stateMachine = new FileStateMachine();
                }
            }

            // Version validation
            if (stateMachine.getStateVersion() != STATE_VERSION) {
                if (TopCollector.exists()) {
                    getTopCollector().announceInformation("Run migration script!", true);
                }
                throw new ServiceUnavailableException("The state version is not the latest version. Run the state upgrade script.");
            }
        }
        return stateMachine;
    }

    // Search provider getter
    public static ISearchProvider getSearchProvider() throws FatalMisconfigurationException, FatalNotImplementedException {
        if (searchProvider == null) {
            if (SEARCH_PROVIDER != null && !SEARCH_PROVIDER.isEmpty()) {
                try {
                    Class<?> clazz = Class.forName(SEARCH_PROVIDER);
                    Object instance = clazz.getDeclaredConstructor().newInstance();
                    if (instance instanceof ISearchProvider) {
                        searchProvider = (ISearchProvider) instance;
                    } else {
                        throw new FatalNotImplementedException("Search provider does not implement ISearchProvider");
                    }
                } catch (ClassNotFoundException e) {
                    includeBackend(SEARCH_PROVIDER);
                } catch (Exception e) {
                    throw new FatalMisconfigurationException("Cannot load search provider: " + e.getMessage());
                }
            } else {
                ISearchProvider sp = getBackend().getSearchProvider();
                if (sp instanceof ISearchProvider) {
                    searchProvider = sp;
                } else {
                    throw new FatalNotImplementedException("Backend returned invalid search provider.");
                }
            }
        }
        return searchProvider;
    }

    // Load backend class dynamically (stub)
    public static boolean includeBackend(String backendName) throws FatalNotImplementedException {
        if (backendName == null || backendName.isEmpty()) return false;

        if (!backendName.toLowerCase().startsWith("backend")) {
            throw new FatalNotImplementedException("Backend '" + backendName + "' is not allowed");
        }

        String className = backendName.substring(7); // strip "backend"
        try {
            Class.forName(className);
            logger.info("Included backend: " + className);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    /**
    * Indicates the latest AS version supported by Z-Push
    *
    * @return String
    */
    public static String getLatestSupportedASVersion() {
        return supportedASVersions.get(supportedASVersions.size() - 1);
    }

    /**
    * Indicates which is the highest AS version supported by the backend
    *
    * @return String
    * @throws FatalNotImplementedException if the backend returns an invalid version
    */
    public static String getSupportedASVersion() throws FatalNotImplementedException {
        String version = getBackend().getSupportedASVersion();
        if (!supportedASVersions.contains(version)) {
            throw new FatalNotImplementedException(
                String.format("AS version '%s' reported by the backend is not supported", version)
            );
        }
        return version;
    }

    /**
    * Returns AS server header
    *
    * @return String
    */
    public static String getServerHeader() throws FatalNotImplementedException {
        if (getSupportedASVersion().equals(ASV_25)) {
            return "MS-Server-ActiveSync: 6.5.7638.1";
        } else {
            return "MS-Server-ActiveSync: " + getSupportedASVersion();
        }
    }

    /**
    * Returns AS protocol versions which are supported
    *
    * @param valueOnly (opt) default false
    * @return String
    */
    public static String getSupportedProtocolVersions(boolean valueOnly) throws FatalNotImplementedException {
        int index = supportedASVersions.indexOf(getSupportedASVersion());
        List<String> versions = supportedASVersions.subList(0, index + 1);
        String versionStr = String.join(",", versions);
        logger.fine("Supported AS versions: " + versionStr);

        return valueOnly ? versionStr : "MS-ASProtocolVersions: " + versionStr;
    }

    /**
    * Returns AS commands which are supported
    *
    * @return String
    */
    public static String getSupportedCommands() throws FatalNotImplementedException {
        List<String> asCommands = new ArrayList<>();
        for (Map.Entry<Integer, Map<Integer, Object>> entry : supportedCommands.entrySet()) {
            int code = entry.getKey();
            Map<Integer, Object> settings = entry.getValue();

            if (!checkCommandOptions(code, NOACTIVESYNCCOMMAND) &&
                checkCommandOptions(code, getSupportedASVersion())) {
                asCommands.add(Utils.getCommandFromCode(code));
            }
        }
        String commands = String.join(",", asCommands);
        logger.fine("Supported AS commands: " + commands);
        return "MS-ASProtocolCommands: " + commands;
    }

    /**
    * Returns the SyncObject class for a folder class
    *
    * @param folderClass
    * @return Object (SyncObject)
    * @throws FatalNotImplementedException
    */
    public static Object getSyncObjectFromFolderClass(String folderClass) throws FatalNotImplementedException {
        if (!classes.containsKey(folderClass)) {
            throw new FatalNotImplementedException("Class '" + folderClass + "' is not supported");
        }

        String className = (String) classes.get(folderClass).get(CLASS_NAME);
        boolean requiresProtocol = (boolean) classes.get(folderClass).get(CLASS_REQUIRESPROTOCOLVERSION);

        try {
            if (requiresProtocol) {
                Constructor<?> ctor = Class.forName(className).getConstructor(int.class);
                return ctor.newInstance(Request.getProtocolVersion());
            } else {
                return Class.forName(className).getDeclaredConstructor().newInstance();
            }
        } catch (Exception e) {
            throw new FatalNotImplementedException("Could not instantiate class: " + e.getMessage());
        }
    }

    /**
    * Returns the default folder type for a folder class
    *
    * @param folderClass
    * @return int
    */
    public static int getDefaultFolderTypeFromFolderClass(String folderClass) {
        logger.fine(String.format("getDefaultFolderTypeFromFolderClass('%s') = %d",
                folderClass, classes.get(folderClass).get(CLASS_DEFAULTTYPE)));
        return (int) classes.get(folderClass).get(CLASS_DEFAULTTYPE);
    }

    /**
    * Returns the folder class for a folder type
    *
    * @param folderType
    * @return String (or null if not found)
    */
    public static String getFolderClassFromFolderType(int folderType) {
        String result = null;
        for (Map.Entry<String, Map<Integer, Object>> entry : classes.entrySet()) {
            Map<Integer, Object> props = entry.getValue();
            if ((int) props.get(CLASS_DEFAULTTYPE) == folderType ||
                ((List<Integer>) props.get(CLASS_OTHERTYPES)).contains(folderType)) {
                result = entry.getKey();
                break;
            }
        }
        logger.fine(String.format("getFolderClassFromFolderType(%d) = %s", folderType, result));
        return result;
    }

    /**
    * Indicates if a command requires authentication
    *
    * @param commandCode
    * @return boolean
    */
    public static boolean commandNeedsAuthentication(int commandCode) throws FatalNotImplementedException {
        boolean status = !checkCommandOptions(commandCode, UNAUTHENTICATED);
        logger.fine(String.format("commandNeedsAuthentication(%d) = %s", commandCode, status));
        return status;
    }

    /**
    * Indicates if the provisioning check has to be enforced for a command
    *
    * @param commandCode
    * @return boolean
    */
    public static boolean commandNeedsProvisioning(int commandCode) throws FatalNotImplementedException {
        boolean status = !checkCommandOptions(commandCode, UNPROVISIONED);
        logger.fine(String.format("commandNeedsProvisioning(%d) = %s", commandCode, status));
        return status;
    }

    /**
    * Indicates if the command expects plain text input instead of WBXML
    *
    * @param commandCode
    * @return boolean
    */
    public static boolean commandNeedsPlainInput(int commandCode) throws FatalNotImplementedException {
        boolean status = checkCommandOptions(commandCode, PLAININPUT);
        logger.fine(String.format("commandNeedsPlainInput(%d) = %s", commandCode, status));
        return status;
    }

    /**
    * Indicates if the command operates on the folder hierarchy
    *
    * @param commandCode
    * @return boolean
    */
    public static boolean hierarchyCommand(int commandCode) throws FatalNotImplementedException {
        boolean status = checkCommandOptions(commandCode, HIERARCHYCOMMAND);
        logger.fine(String.format("hierarchyCommand(%d) = %s", commandCode, status));
        return status;
    }

    /**
    * Checks the access types and capabilities of a command
    *
    * @param commandCode
    * @param option e.g. UNAUTHENTICATED, PLAININPUT, HIERARCHYCOMMAND
    * @return boolean
    * @throws FatalNotImplementedException
    */
    private static boolean checkCommandOptions(int commandCode, Object option) throws FatalNotImplementedException {
        if (commandCode == 0) return false;

        if (!supportedCommands.containsKey(commandCode)) {
            throw new FatalNotImplementedException(
                String.format("Command '%s' is not supported", Utils.getCommandFromCode(commandCode))
            );
        }

        Map<Integer, Object> capabilities = supportedCommands.get(commandCode);
        boolean defaultCapability = capabilities.containsValue(option);

        // if not default capability, check if command is supported since a previous AS version
        if (!defaultCapability && supportedASVersions.contains(option)) {
            int verIndex = supportedASVersions.indexOf(option);
            int cmdVerIndex = supportedASVersions.indexOf(capabilities.get(0));
            if (verIndex >= cmdVerIndex) {
                defaultCapability = true;
            }
        }

        return defaultCapability;
    }

    /**
    * Returns the available provisioning policies.
    *
    * @return Map<String, Map<String, String>>   policies by section and key-value
    */
    public static Map<String, Map<String, String>> getPolicies() {
        // TODO: additional policy providers could be implemented (e.g., for SQL state machine)
        return policies;
    }

}
