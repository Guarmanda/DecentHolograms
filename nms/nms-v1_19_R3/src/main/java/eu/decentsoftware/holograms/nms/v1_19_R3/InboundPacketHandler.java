package eu.decentsoftware.holograms.nms.v1_19_R3;




import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import org.bukkit.entity.Player;

class InboundPacketHandler extends ChannelInboundHandlerAdapter {



    InboundPacketHandler(Player player) {

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object packet) throws Exception {

        super.channelRead(ctx, packet);
    }



}
