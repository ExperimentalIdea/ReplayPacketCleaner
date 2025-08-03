package com.experimentalidea.replaypacketcleaner.protocol;

/** Used to get the protocol version from a version string.
 * Same as with {@link Protocol}, this will likely be replaced at a later time. */
public enum Version {

    MC_1_21(Protocol.V_767, "1.21"),
    MC_1_21_1(Protocol.V_767, "1.21.1"),
    MC_1_21_2(Protocol.V_768, "1.21.2"),
    MC_1_21_3(Protocol.V_768, "1.21.3"),
    MC_1_21_4(Protocol.V_769, "1.21.4"),
    MC_1_21_5(Protocol.V_770, "1.21.5"),
    MC_1_21_6(Protocol.V_771, "1.21.6"),
    MC_1_21_7(Protocol.V_772, "1.21.7"),
    MC_1_21_8(Protocol.V_772, "1.21.8");


    Version(Protocol protocol, String mcVersion) {
        this.protocol = protocol;
        this.mcVersion = mcVersion;
    }

    private final Protocol protocol;
    private final String mcVersion;

    public Protocol getProtocol() {
        return this.protocol;
    }

    public int getProtocolVersion() {
        return this.protocol.getProtocolVersion();
    }

    public String getMCVersion() {
        return this.mcVersion;
    }

    public static Version getVersion(String mcVersion) {
        return switch (mcVersion){
            case "1.21" -> Version.MC_1_21;
            case "1.21.1" -> Version.MC_1_21_1;
            case "1.21.2" -> Version.MC_1_21_2;
            case "1.21.3" -> Version.MC_1_21_3;
            case "1.21.4" -> Version.MC_1_21_4;
            case "1.21.5" -> Version.MC_1_21_5;
            case "1.21.6" -> Version.MC_1_21_6;
            case "1.21.7" -> Version.MC_1_21_7;
            case "1.21.8" -> Version.MC_1_21_8;
            default -> null;
        };

    }

    @Override
    public String toString() {
        return this.getMCVersion();
    }


}
