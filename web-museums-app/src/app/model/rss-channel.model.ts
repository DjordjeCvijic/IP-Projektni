import { ChannelItem } from "./channel-item.model";

export interface RssChannel {
    title: string,
    link: string,
    "atom:link":string,
    description: string,
    // image: string
    channelItems:Array<ChannelItem>;
  }