package io.horizontalsystems.bitcoinkit

import io.horizontalsystems.bitcoincore.models.Block
import io.horizontalsystems.bitcoincore.network.Network
import io.horizontalsystems.bitcoincore.storage.BlockHeader
import io.horizontalsystems.bitcoincore.utils.HashUtils

class MainNet : Network() {

    override var port: Int = 8333

    override var magic: Long = 0xd9b4bef9L
    override var bip32HeaderPub: Int = 0x0488B21E   // The 4 byte header that serializes in base58 to "xpub".
    override var bip32HeaderPriv: Int = 0x0488ADE4  // The 4 byte header that serializes in base58 to "xprv"
    override var addressVersion: Int = 0
    override var addressSegwitHrp: String = "bc"
    override var addressScriptVersion: Int = 5
    override var coinType: Int = 0

    override val maxBlockSize = 1_000_000

    override var dnsSeeds = listOf(
            "seed.bitcoin.sipa.be",             // Pieter Wuille
            "dnsseed.bluematt.me",              // Matt Corallo
            "dnsseed.bitcoin.dashjr.org",       // Luke Dashjr
            "seed.bitcoinstats.com",            // Chris Decker
            "seed.bitcoin.jonasschnelli.ch",    // Jonas Schnelli
            "seed.btc.petertodd.org",           // Peter Todd
            "seed.bitcoin.sprovoost.nl"         // Sjors Provoost
    )

    private val blockHeader = BlockHeader(
            version = 545259520,
            previousBlockHeaderHash = HashUtils.toBytesAsLE("00000000000000000001b2505c11119fcf29be733ec379f686518bf1090a522a"),
            merkleRoot = HashUtils.toBytesAsLE("cc09d95fd8ccc985826b9eb46bf73f8449116f18535423129f0574500985cf90"),
            timestamp = 1556958733,
            bits = 388628280,
            nonce = 2897942742,
            hash = HashUtils.toBytesAsLE("00000000000000000008c8427670a65dec4360e88bf6c8381541ef26b30bd8fc")
    )

    override val checkpointBlock = Block(blockHeader, 574560)
//
//     private val genesisHeader = BlockHeader(
//             version = 1,
//             previousBlockHeaderHash = HashUtils.toBytesAsLE("0000000000000000000000000000000000000000000000000000000000000000"),
//             merkleRoot = HashUtils.toBytesAsLE("4a5e1e4baab89f3a32518a88c31bc87f618f76673e2cc77ab2127b7afdeda33b"),
//             timestamp = 1231006505,
//             bits = 0x1d00ffff,
//             nonce = 2083236893,
//             hash = HashUtils.toBytesAsLE("000000000019d6689c085ae165831e934ff763ae46a2a6c172b3f1b60a8ce26f")
//     )
//
//     override val checkpointBlock = Block(genesisHeader, 0)
}
