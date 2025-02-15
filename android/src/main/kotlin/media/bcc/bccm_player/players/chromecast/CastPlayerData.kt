package media.bcc.bccm_player.players.chromecast

class CastPlayerData {
    var isLive: Boolean? = null
    var mimeType: String? = null
    var lastKnownAudioLanguage: String? = null
    var lastKnownSubtitleLanguage: String? = null

    companion object {
        fun from(extras: Map<String, Any>?): CastPlayerData? {
            if (extras == null) return null
            var playerData: CastPlayerData? = null
            // Example: media.bcc.player.is_live
            for (kv in extras.filter { it.key.contains(CastMediaItemConverter.BCCM_PLAYER_DATA) }) {
                if (playerData == null) playerData = CastPlayerData()
                if (kv.key == CastMediaItemConverter.PLAYER_DATA_IS_LIVE) {
                    playerData.isLive = extras[kv.key] == "true"
                }
                if (kv.key == CastMediaItemConverter.PLAYER_DATA_MIME_TYPE) {
                    playerData.mimeType = extras[kv.key] as? String
                }
                if (kv.key == CastMediaItemConverter.PLAYER_DATA_LAST_KNOWN_AUDIO_LANGUAGE) {
                    playerData.lastKnownAudioLanguage = extras[kv.key] as? String
                }
                if (kv.key == CastMediaItemConverter.PLAYER_DATA_LAST_KNOWN_SUBTITLE_LANGUAGE) {
                    playerData.lastKnownSubtitleLanguage = extras[kv.key] as? String
                }
            }
            return playerData
        }
    }
}